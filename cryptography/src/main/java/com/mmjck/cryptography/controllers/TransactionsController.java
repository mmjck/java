package com.mmjck.cryptography.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.cryptography.controllers.dto.CreateTransactionRequest;
import com.mmjck.cryptography.controllers.dto.TransactionResponse;
import com.mmjck.cryptography.controllers.dto.UpdateTransactionRequest;
import com.mmjck.cryptography.service.TransactionsService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping(value = "/transactions")
public class TransactionsController {

    @Autowired
    private TransactionsService service;

    @PostMapping("/")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateTransactionRequest request) {

        this.service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<Page<TransactionResponse>> listAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "page_size", defaultValue = "10") int pageSize) {
        var response = this.service.listAll(page, pageSize);
        return ResponseEntity
                .ok()
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> findById(@PathVariable(value = "id") Long id) {
        var response = this.service.getById(id);
        return ResponseEntity
                .ok()
                .body(response);
    }

    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionResponse> update(
                    @PathVariable(value = "id") Long id,
                    @RequestBody UpdateTransactionRequest request
                    ) {
        this.service.update(id, request);
        return ResponseEntity.noContent().build();
    }

}
