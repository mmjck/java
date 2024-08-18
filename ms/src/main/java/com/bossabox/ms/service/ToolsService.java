package com.bossabox.ms.service;

import com.bossabox.ms.core.domain.model.Tools;
import com.bossabox.ms.core.repository.ToolsRepository;
import com.bossabox.ms.core.repository.mapper.ToolsJpaModel2ToolsMapper;
import com.bossabox.ms.core.repository.model.ToolsJpaModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolsService {
    private final ToolsRepository repository;

    public ToolsService(ToolsRepository repository) {
        this.repository = repository;
    }


    public Tools create(String title, String description, String link, List<String> tags){
        ToolsJpaModel t = new ToolsJpaModel(title, description, link, tags);

        ToolsJpaModel saved =  this.repository.save(t);

        return ToolsJpaModel2ToolsMapper.mapper(saved);
    }

    public void delete(Long id){
        this.repository.deleteById(id);
    }

    public List<Tools> getAll(){
        var response = this.repository.findAll();
        return  response.stream().map(ToolsJpaModel2ToolsMapper::mapper).toList();
    }

    public List<Tools> findByTag(String tags){
        var response = this.repository.findByTags(tags);
        return  response.stream().map(ToolsJpaModel2ToolsMapper::mapper).toList();
    }

}
