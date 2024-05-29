package com.fraud;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckHistoryService {
    private final FraudCheckHistoryRepository repository;

    public boolean verify(Integer customerId){
            FraudCheckHistory data = FraudCheckHistory.builder()
            .customerId(customerId)
            .build();

            this.repository.save(data);
            return false;
    }


}
