package com.mmjck.anota_ai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mmjck.anota_ai.domain.category.exceptions.CategoryNotFoundException;
import com.mmjck.anota_ai.domain.product.Product;
import com.mmjck.anota_ai.domain.product.dto.ProductDTO;
import com.mmjck.anota_ai.domain.product.exceptions.ProductNotFoundException;
import com.mmjck.anota_ai.repositories.ProductRepository;
import com.mmjck.anota_ai.services.aws.AwsSnsService;
import com.mmjck.anota_ai.services.aws.dto.MessageDTO;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final CategoryService categoryService;
    
    private final AwsSnsService snsService;
    


    public ProductService(ProductRepository repository, CategoryService categoryService, AwsSnsService snsService) {
        this.repository = repository;
        this.categoryService = categoryService;
        this.snsService = snsService;
    }


    public Product save(ProductDTO data){
        this.categoryService.getById(data.categoryId()).orElseThrow(CategoryNotFoundException::new);

        Product entity = new Product(data);
        
        this.repository.save(entity);
        this.snsService.publish(new MessageDTO(entity.toString()));
        
        return entity;
    }


    public Product update(String id, ProductDTO dto){
        Product entity = this.repository.findById(id).orElseThrow(ProductNotFoundException::new); 
        
        if(dto.categoryId() != null){
            this.categoryService.getById(dto.categoryId()).orElseThrow(CategoryNotFoundException::new);
            entity.setCategoryId(dto.categoryId());
        }

        if(!dto.title().isEmpty()) {
            entity.setTitle(dto.title());
        }

        if(!dto.description().isEmpty()) {
            entity.setDescription(dto.description());
        }

        if(!(dto.price() == null)) {
            entity.setPrice(dto.price());
        }

        
        this.repository.save(entity);
        this.snsService.publish(new MessageDTO(entity.toString()));
        return  entity;
    }



    public void delete(String id){
        this.repository.findById(id).orElseThrow(ProductNotFoundException::new); 
        this.repository.deleteById(id);
    }


    public List<Product> getAll(){
        List<Product> categories = this.repository.findAll();
        return  categories;
    }
}
