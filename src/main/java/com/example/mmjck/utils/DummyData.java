package com.example.mmjck.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mmjck.codeblog.model.Post;
import com.example.mmjck.codeblog.repository.CodeblogRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DummyData {

    @Autowired
    CodeblogRepository repository;

    // @PostConstruct
    public void savePosts() {
        System.out.println("===== SAVE DATA =====");
        List<Post> postList = new ArrayList<>();
        Post post1 = new Post();
        post1.setAuthor("Joao da Silva");
        post1.setCreatedAt(LocalDate.now());
        post1.setTitle("Docker");
        post1.setText(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        Post post2 = new Post();
        post2.setAuthor("Maria Medeiros");
        post2.setCreatedAt(LocalDate.now());
        post2.setTitle("API REST");
        post2.setText(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

        postList.add(post1);
        postList.add(post2);

        try {
            for (Post post : postList) {
                Post postSaved = repository.save(post);
                System.out.println("===== SAVE DATA =====");
                System.out.println(postSaved.getId());
            }    
        } catch (Exception e) {
           e.printStackTrace();
        }
        
    }

}
