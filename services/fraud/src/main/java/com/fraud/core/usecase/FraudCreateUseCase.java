package com.fraud.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;

import com.fraud.core.entity.FraudCheckHistory;
import com.fraud.dataprovider.FraudCheckHistoryDataProvider;


public class FraudCreateUseCase {
    @Autowired
    private FraudCheckHistoryDataProvider provider;

    public FraudCheckHistory execute(Integer customerId){
        return this.provider.create(customerId);
    }
}
