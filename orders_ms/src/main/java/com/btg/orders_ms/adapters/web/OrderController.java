package com.btg.orders_ms.adapters.web;

import org.springframework.web.bind.annotation.RestController;

import com.btg.orders_ms.adapters.web.dto.ApiResponse;
import com.btg.orders_ms.adapters.web.dto.OrderResponse;
import com.btg.orders_ms.adapters.web.dto.PaginationResponse;
import com.btg.orders_ms.application.port.incoming.ListOrdersUseCase;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class OrderController {

    private final ListOrdersUseCase listOrdersUseCase;

    public OrderController(ListOrdersUseCase listOrdersUseCase) {
        this.listOrdersUseCase = listOrdersUseCase;
    }

    @GetMapping("/customer/{customerId}/orders")
    public 
    ResponseEntity<ApiResponse<OrderResponse>> 
    listOrders(
            @PathVariable("customerId") Long customerId,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {

        Page<OrderResponse> pageResponse = 
            listOrdersUseCase
            .findAllByCustomerId(customerId, PageRequest.of(page, pageSize))
            .map(OrderResponse::fromEntity);

        BigDecimal totalOrders = listOrdersUseCase.findTotalOnOrdersByCustomerId(customerId);
        
        return ResponseEntity.ok(new ApiResponse<>(
            Map.of("total_orders", totalOrders),
            pageResponse.getContent(),
            PaginationResponse.fromPage(pageResponse)
        ));
    }

}
