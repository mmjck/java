package com.customer.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.core.entity.Customer;
import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    Optional<Customer> findByEmail(String email);
}
