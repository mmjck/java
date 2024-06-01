package com.fraud.core.usecase;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.fraud.core.entity.FraudCheckHistory;
import com.fraud.dataprovider.FraudCheckHistoryDataProvider;

public class FraudCheckListUseCase {
    @Autowired
    private FraudCheckHistoryDataProvider provider;

    public Optional<FraudCheckHistory> execute(Integer customerId){
        Optional<FraudCheckHistory> customer = this.provider.findByCustomerId(customerId);
        return customer;
    }
}
