package com.customer;

import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class  CustomerController {
    @Autowired
    private CustomerService service;
    
    @PostMapping
    public void create(@RequestBody CustomerDto data){
        log.info("new customer registration {}", data);
        service.create(data);
    }
}
