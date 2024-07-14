package com.btg.orders_ms.application.port.incoming;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.btg.orders_ms.entity.OrderEntity;

public interface ListOrdersUseCase {
    List<OrderEntity> list();
    Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest);

    BigDecimal findTotalOnOrdersByCustomerId(Long customerId);
}
