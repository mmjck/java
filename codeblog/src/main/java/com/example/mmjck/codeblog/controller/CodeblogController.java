package com.example.mmjck.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.mmjck.codeblog.model.Post;
import com.example.mmjck.codeblog.service.CodeblogService;

import jakarta.validation.Valid;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class CodeblogController {
    @Autowired
    CodeblogService service;
    
    @GetMapping("/posts")
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        mv.addObject("posts", posts);

        return mv;
    } 


    @GetMapping("/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("post-details");
        Post post = service.findById(id);

        mv.addObject("post", post);

        return mv;
    }
    
    @GetMapping("/new-post")
    public ModelAndView getPostForm() {
        ModelAndView mv = new ModelAndView("new-post");
        return mv;
    }


    @PostMapping("/add-post")
    public String savePost(@Valid Post data, BindingResult result, RedirectAttributes attributes) {
        System.out.println("has error");
        System.out.println(result.hasErrors());
        if(result.hasErrors()){
            attributes.addFlashAttribute("message", "Verifique se os campos obrigatórios foram preenchidos");
            return "redirect:/new-post";
        }

        data.setCreatedAt(LocalDate.now());

        this.service.save(data);
        return "redirect:/posts";
    }
    
    
    
    
}
