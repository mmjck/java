package com.mmjck.cryptography.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mmjck.cryptography.entities.TransactionEntity;

public interface TransactionsRepository extends JpaRepository<TransactionEntity, Long>{}
