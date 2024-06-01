package com.fraud.entrypoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fraud.core.entity.FraudCheckHistory;
import com.fraud.core.usecase.FraudCheckHistoryUseCase;
import com.fraud.core.usecase.FraudCreateUseCase;
import com.fraud.dataprovider.FraudCheckHistoryDataProvider;
import com.fraud.entrypoint.dto.FraudCheckResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudEntrypoint {
    @Autowired
    FraudCheckHistoryUseCase useCase;

    @GetMapping(path = "{customerId}")
    public ResponseEntity<Object> create(@PathVariable("customerId") Integer customerId) {

        log.info("fraud check request for customer {}", customerId);
        try {
            FraudCheckResponse response = useCase.execute(customerId);
            
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }


    }
    
}
