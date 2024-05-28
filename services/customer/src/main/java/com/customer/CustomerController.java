package com.customer;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class  CustomerController {

    private final CustomerService service;
    
    @PostMapping
    public void create(@RequestBody CustomerRegistrationRequest data){
        log.info("new customer registration {}", data);
        service.create(data);
    }
}
