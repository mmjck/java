package com.btg.orders_ms.adapters.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.btg.orders_ms.entity.OrderEntity;

public interface SpringDataOrderRepository extends MongoRepository<OrderEntity, Long>{

    Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest);
    
}
