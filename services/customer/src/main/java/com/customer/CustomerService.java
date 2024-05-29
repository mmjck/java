package com.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomerService{
    
    @Autowired
    private  CustomerRepository repository;
    
    @Autowired
    private  RestTemplate restTemplate;


    public void create(CustomerDto data){
        Customer customer = Customer.builder()
            .firstName(data.getFirstName())
            .lastName(data.getLastName())
            .email(data.getEmail())
            .build();

        // todo: check if email valid
        // todo: check if email not taken
        repository.saveAndFlush(customer);
           
        // todo: check if fraudster
        FraudCheckResponse response = restTemplate.getForObject(
            "http://localhost:8081/api/v1/fraud-check/{customerId}", 
            FraudCheckResponse.class,
            customer.getId()
        );

        if(response.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        // todo: send notification
    }
}
