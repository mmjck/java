package com.mmjck.anota_ai.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mmjck.anota_ai.domain.category.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String>{
    
}
