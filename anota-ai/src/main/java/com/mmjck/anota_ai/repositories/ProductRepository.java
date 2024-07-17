package com.mmjck.anota_ai.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mmjck.anota_ai.domain.product.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String>{
    
}
