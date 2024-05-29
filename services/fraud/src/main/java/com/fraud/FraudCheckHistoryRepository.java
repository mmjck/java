package com.fraud;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FraudCheckHistoryRepository extends MongoRepository<FraudCheckHistory, String>{}
