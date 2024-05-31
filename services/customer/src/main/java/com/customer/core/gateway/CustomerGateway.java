package com.customer.core.gateway;

import java.util.Optional;

import com.customer.core.entity.Customer;

public interface CustomerGateway {
    public Customer create(Customer data);
    public Optional<Customer> findByEmail(String email);
}
