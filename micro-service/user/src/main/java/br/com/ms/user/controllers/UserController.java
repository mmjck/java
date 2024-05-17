package br.com.ms.user.controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.ms.user.dtos.UserRecordDto;
import br.com.ms.user.model.UserModel;
import br.com.ms.user.service.UserService;
import jakarta.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {

    final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> create(@Valid @RequestBody UserRecordDto dto) {
        var userModel = new UserModel();
        BeanUtils.copyProperties(dto, userModel);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(userModel));
    }

}
