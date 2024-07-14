package com.btg.orders_ms.application.port.incoming;

import com.btg.orders_ms.dto.OrderCreatedEvent;
import com.btg.orders_ms.entity.OrderEntity;

public interface CreateOrderUseCase {
    OrderEntity save(OrderCreatedEvent event);
}
