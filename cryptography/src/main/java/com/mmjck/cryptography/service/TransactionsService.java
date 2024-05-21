package com.mmjck.cryptography.service;

import org.springframework.data.domain.Page;
import com.mmjck.cryptography.controllers.dto.CreateTransactionRequest;
import com.mmjck.cryptography.controllers.dto.TransactionResponse;
import com.mmjck.cryptography.controllers.dto.UpdateTransactionRequest;

public interface TransactionsService {
    public void create(CreateTransactionRequest request);

    public Page<TransactionResponse> listAll(int page, int pageSize);
    public TransactionResponse getById(Long id);
    public void delete(Long id);
    public void update(Long id, UpdateTransactionRequest request);
}
