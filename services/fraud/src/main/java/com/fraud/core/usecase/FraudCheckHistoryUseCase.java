package com.fraud.core.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fraud.core.entity.FraudCheckHistory;
import com.fraud.entrypoint.dto.FraudCheckResponse;

public class FraudCheckHistoryUseCase {
    @Autowired
    FraudCreateUseCase fraudCreateUseCase;

    @Autowired
    FraudCheckListUseCase fraudCheckListUseCase;

    public FraudCheckResponse execute(Integer customerId){
        Optional<FraudCheckHistory> customer = fraudCheckListUseCase.execute(customerId);

        if(customer.isPresent()){
            return FraudCheckResponse.builder().customerId(customerId)
            .isFraudster(customer.get().getIsFraudster()).build();
            
        }

        fraudCreateUseCase.execute(customerId);

        return FraudCheckResponse
            .builder()
            .customerId(customerId)
            .isFraudster(customer.get().getIsFraudster())
            .build();

    }
}
