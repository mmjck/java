package com.btg.orders_ms.dto;

import java.util.List;

public record OrderCreatedEvent(
    Long codigoPedido,
    Long codigoCliente,
    List<OrderItemEvent> itens
) {
    
}
