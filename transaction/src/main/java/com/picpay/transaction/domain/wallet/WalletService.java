package com.picpay.transaction.domain.wallet;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }


    public void save(Wallet wallet){
        this.walletRepository.save(wallet);
    }


    public Optional<Wallet> findById(Long id) {
        return this.walletRepository.findById(id);
    }
}
