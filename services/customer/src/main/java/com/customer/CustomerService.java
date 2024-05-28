package com.customer;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService{
    private final CustomerRepository repository;
    public void create(CustomerRegistrationRequest data){
        Customer customer = Customer.builder()
            .firstName(data.firstName())
            .lastName(data.lastName())
            .email(data.email())
            .build();

        // todo: check if email valid
        // todo: check if email not taken
        // todo: check customer in db
        repository.save(customer);
    }
}
