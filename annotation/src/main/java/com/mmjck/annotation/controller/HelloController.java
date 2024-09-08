package com.mmjck.annotation.controller;

import com.mmjck.annotation.logging.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Log
    @GetMapping
    public ResponseEntity<Void> hello(){
        return ResponseEntity.ok().build();
    }
}
