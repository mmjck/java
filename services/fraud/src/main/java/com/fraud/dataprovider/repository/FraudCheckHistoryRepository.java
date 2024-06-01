package com.fraud.dataprovider.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.fraud.core.entity.FraudCheckHistory;
import java.util.Optional;


public interface FraudCheckHistoryRepository extends MongoRepository<FraudCheckHistory, String>{
    Optional<FraudCheckHistory> findByCustomerId(Integer customerId);
}
