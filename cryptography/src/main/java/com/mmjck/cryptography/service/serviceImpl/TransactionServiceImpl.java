package com.mmjck.cryptography.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mmjck.cryptography.controllers.dto.CreateTransactionRequest;
import com.mmjck.cryptography.controllers.dto.TransactionResponse;
import com.mmjck.cryptography.controllers.dto.UpdateTransactionRequest;
import com.mmjck.cryptography.entities.TransactionEntity;
import com.mmjck.cryptography.repository.TransactionsRepository;
import com.mmjck.cryptography.service.TransactionsService;


@Service
public class TransactionServiceImpl implements TransactionsService {
    @Autowired
    private TransactionsRepository repository;

    @Override
    public void create(CreateTransactionRequest request) {
        var entity = new TransactionEntity();
        entity.setRawCreditCardToken(request.creditCardToken());
        entity.setRawUserDocument(request.userDocument());
        entity.setTransactionValue(request.value());

        this.repository.save(entity);
    }

    @Override
    public Page<TransactionResponse> listAll(int page, int pageSize) {
        var content = this.repository.findAll(PageRequest.of(page, pageSize));
        return content.map(TransactionResponse::fromEntity);
    }

    @Override
    public TransactionResponse getById(Long id) {
        var content = this.repository
            .findById(id)
            .orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        return TransactionResponse.fromEntity(content);
    }

    @Override
    public void update(Long id, UpdateTransactionRequest request) {
        var entity = this.repository
        .findById(id)
        .orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND));

        entity.setTransactionValue(request.value());
        this.repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        var entity = this.repository
        .findById(id)
        .orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND));

        this.repository.deleteById(entity.getId());
    }

}
