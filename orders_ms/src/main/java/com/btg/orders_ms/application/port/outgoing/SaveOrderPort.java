package com.btg.orders_ms.application.port.outgoing;

import com.btg.orders_ms.entity.OrderEntity;

public interface SaveOrderPort {
    OrderEntity save(OrderEntity entity);
}
