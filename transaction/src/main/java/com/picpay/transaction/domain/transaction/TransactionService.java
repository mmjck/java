package com.picpay.transaction.domain.transaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picpay.transaction.domain.authorization.AuthorizerService;
import com.picpay.transaction.domain.notification.NotificationService;
import com.picpay.transaction.domain.wallet.Wallet;
import com.picpay.transaction.domain.wallet.WalletRepository;
import com.picpay.transaction.domain.wallet.WalletService;
import com.picpay.transaction.domain.wallet.WalletType;

@Service
public class TransactionService {

    // repositories
    private final TransactionRepository transactionRepository;
    
    // services
    private final AuthorizerService authorizerService;
    private final NotificationService notificationService;
    private final WalletService walletService;
    
    
    public TransactionService(
            TransactionRepository transactionRepository, 
            WalletRepository walletRepository,
            AuthorizerService authorizerService,
            WalletService walletService,
            NotificationService notificationService) {
        
        this.transactionRepository = transactionRepository;
        this.walletService = walletService;
        this.authorizerService = authorizerService;
        this.notificationService = notificationService;
    }

    @Transactional
    public Transaction create(Transaction transaction) {

        // validate transaction
        this.validate(transaction);

        // create transaction
        var newTransaction = this.transactionRepository.save(transaction);

        // debit from wallet


        Wallet walletPayer = walletService.findById(transaction.payer()).get();
        walletService.save(walletPayer.debit(transaction.value()));
        

        Wallet walletPayee = walletService.findById(transaction.payee()).get();
        walletService.save(walletPayee.credit(transaction.value()));

        /// call external services
        // authorize transaction
        authorizerService.authorize(transaction);


        // notify
        notificationService.notifier(transaction);
        return newTransaction;
    }

    // the payer has a common wallet
    // the payer has enough balance
    // the payer is not the payee
    private void validate(Transaction transaction) {
        this.walletService.findById(transaction.payee())
                .map(payee -> this.walletService.findById(transaction.payer())
                        .map(payer -> isTransactionValid(transaction, payer) ? transaction : null)
                        .orElseThrow(() -> new InvalidTransactionException(
                                "Invalid transaction - %s".formatted(transaction))))
                .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - %s".formatted(transaction)));

    }

    private boolean isTransactionValid(Transaction transaction, Wallet payer) {
        return payer.type() == WalletType.COMUN.getValue() &&
                payer.balance().compareTo(transaction.value()) >= 0 &&
                !payer.id().equals(transaction.payee());

    }

    public List<Transaction> findAll(){
        return this.transactionRepository.findAll();
    }
}
