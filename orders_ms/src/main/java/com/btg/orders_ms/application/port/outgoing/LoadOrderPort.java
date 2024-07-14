package com.btg.orders_ms.application.port.outgoing;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.btg.orders_ms.entity.OrderEntity;



public interface LoadOrderPort {
    Optional<OrderEntity> findById(Long id);
    List<OrderEntity> findAll();
    Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest);
    BigDecimal findTotalOnOrdersByCustomerId(Long customerId);
}
