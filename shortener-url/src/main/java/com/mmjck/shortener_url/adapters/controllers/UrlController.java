package com.mmjck.shortener_url.adapters.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.shortener_url.adapters.controllers.model.request.ShortenUrlRequest;
import com.mmjck.shortener_url.domain.useCases.createurl.CreateUrlUseCase;
import com.mmjck.shortener_url.domain.useCases.listUrl.ListUrlUseCase;
import com.mmjck.shortener_url.domain.useCases.redirectUrl.RedirectUrlUseCase;

import jakarta.servlet.http.HttpServletRequest;



@RestController
public class UrlController {
    private final CreateUrlUseCase createUrlUseCase;
    private final RedirectUrlUseCase redirectUrlUseCase;
    private final ListUrlUseCase listUrlUseCase;

    public UrlController(CreateUrlUseCase createUrlUseCase, ListUrlUseCase listUrlUseCase,
            RedirectUrlUseCase redirectUrlUseCase) {
        this.createUrlUseCase = createUrlUseCase;
        this.listUrlUseCase = listUrlUseCase;
        this.redirectUrlUseCase = redirectUrlUseCase;
    }

    @PostMapping(value = "shortener")
    public ResponseEntity<Object> create(@RequestBody ShortenUrlRequest request,
            HttpServletRequest servletRequest){
        try {
            var response = this.createUrlUseCase.execute(request, servletRequest);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) { 
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping(value = "{id}")
    public  ResponseEntity<Object> redirect(@PathVariable("id") String id) {
        try {
            var response = this.redirectUrlUseCase.execute(id);
            return ResponseEntity.status(HttpStatus.FOUND).headers(response).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping(value = "urls")
    public  ResponseEntity<Object> list() {
        try {
            var response = this.listUrlUseCase.execute();
            return ResponseEntity.ok().body(response);    
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
    
}
