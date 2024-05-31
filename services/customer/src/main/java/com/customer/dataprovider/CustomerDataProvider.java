package com.customer.dataprovider;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.core.entity.Customer;
import com.customer.core.gateway.CustomerGateway;
import com.customer.dataprovider.repository.CustomerRepository;
import com.customer.entrypoint.dto.CustomerRequestDto;


@Service
public class CustomerDataProvider implements CustomerGateway {
    
    @Autowired
    private  CustomerRepository customerRepository;
    
    // @Autowired
    // private  RestTemplate restTemplate;


    

    public Customer create(Customer data){
    
        // todo: check if email valid
        // todo: check if email not taken
        return customerRepository.saveAndFlush(data);
        // // todo: check if fraudster
        // FraudCheckResponse response = restTemplate.getForObject(
        //     "http://FRAUD/api/v1/fraud-check/{customerId}", 
        //     FraudCheckResponse.class,
        //     customer.getId()
        // );

        // if(response.isFraudster()){
        //     throw new IllegalStateException("fraudster");
        // }

        // todo: send notification
    }

    @Override
    public Optional<Customer> findByEmail(String email) {
        return this.customerRepository.findByEmail(email);
    }
}
