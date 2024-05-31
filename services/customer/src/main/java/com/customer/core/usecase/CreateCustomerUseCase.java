package com.customer.core.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.configuration.exception.UserAlreadyExistsException;
import com.customer.core.entity.Customer;
import com.customer.core.gateway.CustomerGateway;
import com.customer.entrypoint.dto.CustomerRequestDto;

@Service
public class CreateCustomerUseCase {

    @Autowired
    CustomerGateway customerGateway;

    public Customer execute(CustomerRequestDto data) throws RuntimeException {
        this.customerGateway.findByEmail(data.getEmail()).ifPresent((e) -> {
            throw new UserAlreadyExistsException();
        });

        Customer customer = Customer.builder()
                .firstName(data.getFirstName())
                .lastName(data.getLastName())
                .email(data.getEmail())
                .build();

        return customerGateway.create(customer);
    }
}
