package com.mmjck.shortener_url.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.shortener_url.controllers.dto.ShortenUrlRequest;
import com.mmjck.shortener_url.useCases.UrlUseCase;

import jakarta.servlet.http.HttpServletRequest;



@RestController
public class UrlController {
    @Autowired
    private UrlUseCase useCase;

    @PostMapping(value = "shortener")
    public ResponseEntity<Object> create(@RequestBody ShortenUrlRequest request,
            HttpServletRequest servletRequest){
    
        try {
            var redirectUrl = this.useCase.execute(request, servletRequest);
            return ResponseEntity.ok().body(redirectUrl);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }
    }
}
