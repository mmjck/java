package com.btg.orders_ms.dto;

import java.math.BigDecimal;

public record OrderItemEvent(
    String produto,
    Integer quantidade,
    BigDecimal preco
) {
    
}
