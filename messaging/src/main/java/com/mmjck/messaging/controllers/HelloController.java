package com.mmjck.messaging.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.messaging.producers.HelloProducer;

@RestController
@RequestMapping("/kakfa")
public class HelloController {
    private HelloProducer service;

    public HelloController(HelloProducer service) {
        this.service = service;
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String message){
        service.sendMessage(message);
        return "OK";
    }
}
