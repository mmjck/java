package com.btg.orders_ms.adapters.web.dto;

import java.math.BigDecimal;

import com.btg.orders_ms.entity.OrderEntity;

public record OrderResponse(
        Long orderId,
        Long customerId,
        BigDecimal total) {

    public static OrderResponse fromEntity(OrderEntity entity) {
        return new OrderResponse(entity.getOrderId(), entity.getCustomerId(), entity.getTotal());
    }
}
