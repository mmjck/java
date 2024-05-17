package com.example.mmjck.codeblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mmjck.codeblog.model.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long>{}
