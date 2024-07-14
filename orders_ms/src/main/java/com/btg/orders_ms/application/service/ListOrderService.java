package com.btg.orders_ms.application.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.btg.orders_ms.application.port.incoming.ListOrdersUseCase;
import com.btg.orders_ms.application.port.outgoing.LoadOrderPort;
import com.btg.orders_ms.entity.OrderEntity;


@Service
public class ListOrderService implements ListOrdersUseCase {

    private final LoadOrderPort loadOrderPort;

    public ListOrderService(LoadOrderPort loadOrderPort) {
        this.loadOrderPort = loadOrderPort;
    }

    @Override
    public List<OrderEntity> list() {
        return this.loadOrderPort.findAll();
    }

    @Override
    public BigDecimal findTotalOnOrdersByCustomerId(Long customerId) {
        return this.loadOrderPort.findTotalOnOrdersByCustomerId(customerId);
    }

    @Override
    public Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        var orders = loadOrderPort.findAllByCustomerId(customerId, pageRequest);
        return orders;
    }

}
