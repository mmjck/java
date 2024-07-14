package com.btg.orders_ms.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.btg.orders_ms.application.port.incoming.CreateOrderUseCase;
import com.btg.orders_ms.application.port.outgoing.SaveOrderPort;
import com.btg.orders_ms.dto.OrderCreatedEvent;
import com.btg.orders_ms.entity.OrderEntity;
import com.btg.orders_ms.entity.OrderItem;

@Service
public class CreateOrderService implements CreateOrderUseCase {

    private final SaveOrderPort saveOrderPort;

    public CreateOrderService(
            SaveOrderPort saveOrderPort) {
        this.saveOrderPort = saveOrderPort;
    }

    public OrderEntity save(OrderCreatedEvent event) {
        OrderEntity entity = OrderEntity.builder()
                .customerId(event.codigoCliente())
                .orderId(event.codigoPedido())
                .items(getOrderItems(event))
                .total(getTotal(event))
                .build();

        return this.saveOrderPort.save(entity);
    }

    private static List<OrderItem> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(i -> OrderItem.builder()
                        .product(i.produto())
                        .quantity(i.quantidade())
                        .price(i.preco())
                        .build())
                .toList();
    }

    private BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens()
                .stream()
                .map(i -> i.preco()
                        .multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

}
