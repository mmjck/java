package com.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraudCheckHistoryService {
    
    @Autowired
    private FraudCheckHistoryRepository repository;

    public boolean verify(Integer customerId){
            FraudCheckHistory data = FraudCheckHistory.builder()
            .customerId(customerId)
            .build();

            this.repository.save(data);
            return false;
    }


}
