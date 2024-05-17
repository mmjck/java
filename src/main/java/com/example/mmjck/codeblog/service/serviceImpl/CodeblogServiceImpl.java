package com.example.mmjck.codeblog.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mmjck.codeblog.model.Post;
import com.example.mmjck.codeblog.repository.CodeblogRepository;
import com.example.mmjck.codeblog.service.CodeblogService;


@Service
public class CodeblogServiceImpl implements CodeblogService{

    @Autowired
    CodeblogRepository repository;

    @Override
    public List<Post> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public Post save(Post data) {
        return this.repository.save(data);
    }
    
}
