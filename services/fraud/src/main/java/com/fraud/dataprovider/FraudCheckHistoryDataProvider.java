package com.fraud.dataprovider;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fraud.core.entity.FraudCheckHistory;
import com.fraud.core.gateway.FraudCheckHistoryGateway;
import com.fraud.dataprovider.repository.FraudCheckHistoryRepository;

@Service
public class FraudCheckHistoryDataProvider implements FraudCheckHistoryGateway {
    
    @Autowired
    private FraudCheckHistoryRepository repository;

    public FraudCheckHistory create(Integer customerId){
            FraudCheckHistory data = FraudCheckHistory.builder()
            .customerId(customerId)
            .build();
            
            return this.repository.save(data);
    }

    @Override
    public Optional<FraudCheckHistory> findByCustomerId(Integer customerId) {
        return this.repository.findByCustomerId(customerId);
    }


}
