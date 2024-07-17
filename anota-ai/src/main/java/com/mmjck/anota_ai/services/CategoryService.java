package com.mmjck.anota_ai.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mmjck.anota_ai.domain.category.Category;
import com.mmjck.anota_ai.domain.category.dto.CategoryDTO;
import com.mmjck.anota_ai.domain.category.exceptions.CategoryNotFoundException;
import com.mmjck.anota_ai.repositories.CategoryRepository;
import com.mmjck.anota_ai.services.aws.AwsSnsService;
import com.mmjck.anota_ai.services.aws.dto.MessageDTO;

@Service
public class CategoryService {
    private final CategoryRepository repository;
    private final AwsSnsService snsService;


    public CategoryService(CategoryRepository repository, AwsSnsService snsService) {
        this.repository = repository;
        this.snsService = snsService;
    }


    public Category save(CategoryDTO data){
        Category entity = new Category(data);
        this.repository.save(entity);
        this.snsService.publish(new MessageDTO(entity.toString()));
        return  entity;
    }


    public Category update(String id, CategoryDTO data){
        Category entity = this.repository.findById(id).orElseThrow(CategoryNotFoundException::new); 
        
        if(data.title() != null) {
            entity.setTitle(data.title());
        }


        if(data.description() != null) {
            entity.setDescription(data.description());
        }

        this.repository.save(entity);
        this.snsService.publish(new MessageDTO(entity.toString()));
        return  entity;
    }



    public void delete(String id){
        this.repository.findById(id).orElseThrow(CategoryNotFoundException::new); 

        this.repository.deleteById(id);
    }


    public List<Category> getAll(){
        List<Category> categories = this.repository.findAll();
        return  categories;
    }


    public Optional<Category> getById(String id){
        Optional<Category> category = this.repository.findById(id);
        return category;
    }

}
