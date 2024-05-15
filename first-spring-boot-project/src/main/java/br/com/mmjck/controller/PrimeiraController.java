package br.com.mmjck.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController()
@RequestMapping("/fisrt-controller")
public class PrimeiraController {

    @GetMapping("/method-one")
    public String helloWorld(@PathVariable String id) {
        return "Hello world!!";
    }

    @GetMapping("/method-one/{id}")
    public String withPath(@PathVariable String id) {
        return "The value is: " + id;
    }

    @GetMapping("/method-two/{id}")
    public String withParams(@RequestParam String id) {
        return "[withParams] The query  is: " + id;
    }

    @GetMapping("/method-three")
    public String withParams2(@RequestParam Map<String, String> allParams) {
        return "[withParams2] The query is: " + allParams.entrySet();
    }

    @PostMapping("/with-body")
    public String withBody(@RequestBody User user) {
        return "[with-body] Data: " + user.name;
    }

    @PostMapping("/with-headers")
    public String withHeader(@RequestHeader("name") String name) {
        return "[with-header] Data: " + name;
    }

    @PostMapping("/with-list-headers")
    public String withListHeader(@RequestHeader Map<String, String> headers) {
        return "[with-header] Data: " + headers.entrySet();
    }

    @GetMapping("/response-entity/{id}")
    public ResponseEntity<Object> methodResponseEntity(@PathVariable Long id) {

        var user = new User("joao");

        if (id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");

    }

    record User(String name) {
    }
}
