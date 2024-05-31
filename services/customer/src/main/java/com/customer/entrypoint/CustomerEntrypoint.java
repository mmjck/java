package com.customer.entrypoint;

import org.springframework.web.bind.annotation.RestController;

import com.customer.core.entity.Customer;
import com.customer.core.usecase.CreateCustomerUseCase;
import com.customer.entrypoint.dto.CustomerRequestDto;

import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class  CustomerEntrypoint {
    @Autowired
    private CreateCustomerUseCase useCase;
    
    @PostMapping
    public ResponseEntity<Object> create(@Valid @RequestBody CustomerRequestDto data){
        
        try {
            log.info("new customer registration {}", data);
            Customer customer = this.useCase.execute(data);
            return ResponseEntity.ok().body(customer);
        } catch (Exception e) {
            log.error("new customer registration {}", e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
