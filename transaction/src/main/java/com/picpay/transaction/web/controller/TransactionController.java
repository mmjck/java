package com.picpay.transaction.web.controller;

import org.springframework.web.bind.annotation.RestController;

import com.picpay.transaction.domain.transaction.Transaction;
import com.picpay.transaction.domain.transaction.TransactionService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("transactions")
public class TransactionController {
    
    private final TransactionService transactionService;
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }


    @PostMapping
    public Transaction create(@RequestBody Transaction request) {
        LOGGER.info("validating transaction {}...", request);
        return transactionService.create(request);
    }


    @GetMapping
    public List<Transaction> getAll() {
        return this.transactionService.findAll();
    }
    
    
}
