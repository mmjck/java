package com.fraud.core.gateway;

import java.util.Optional;

import com.fraud.core.entity.FraudCheckHistory;

public interface FraudCheckHistoryGateway {
    public FraudCheckHistory create(Integer customerId);
    public Optional<FraudCheckHistory> findByCustomerId(Integer customerId);
}
