package com.customer.core.usecase;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.core.entity.Customer;
import com.customer.entrypoint.producer.CustomerProducer;

@Service
public class SendEmailUseCase {
    @Autowired
    private CustomerProducer producer;


    public void execute(Customer customer){
        producer.publish(customer);
    }
}
