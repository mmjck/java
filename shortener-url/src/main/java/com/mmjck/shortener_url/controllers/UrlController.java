package com.mmjck.shortener_url.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.shortener_url.useCases.createurl.CreateUrlUseCase;
import com.mmjck.shortener_url.useCases.createurl.dto.ShortenUrlRequest;
import com.mmjck.shortener_url.useCases.listUrl.ListUrlUseCase;
import com.mmjck.shortener_url.useCases.redirectUrl.RedirectUrlUseCase;

import jakarta.servlet.http.HttpServletRequest;



@RestController
public class UrlController {
    @Autowired
    private CreateUrlUseCase createUrlUseCase;

    @Autowired
    private ListUrlUseCase listUrlUseCase;

    @Autowired
    private RedirectUrlUseCase redirectUrlUseCase;

    @PostMapping(value = "shortener")
    public ResponseEntity<Object> create(@RequestBody ShortenUrlRequest request,
            HttpServletRequest servletRequest){
    
        try {
            var redirectUrl = this.createUrlUseCase.execute(request, servletRequest);
            return ResponseEntity.ok().body(redirectUrl);
        } catch (Exception e) { 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }


    @GetMapping("/")
    public  ResponseEntity<Object> redirect(@PathVariable("id") String id) {
        try {
            this.redirectUrlUseCase.execute(id);
            return ResponseEntity.ok().body(new Object());    
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
        

    }


    @GetMapping("/urls")
    public  ResponseEntity<Object> list() {
        try {
            var response = this.listUrlUseCase.execute();
            return ResponseEntity.ok().body(response);    
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
        

    }
    
}
