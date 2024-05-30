package com.fraud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/fraud-check")
@Slf4j
public class FraudController {
    
    @Autowired
    private FraudCheckHistoryService service;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse create(@PathVariable("customerId") Integer customerId) {

        log.info("fraud check request for customer {}", customerId);

        boolean isFraudulentCustomer = this.service.verify(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
    
}
