package com.example.mmjck.codeblog.service;

import java.util.List;

import com.example.mmjck.codeblog.model.Post;

public interface CodeblogService {
    List<Post> findAll();
    Post findById(Long id);
    Post save(Post data);
}
