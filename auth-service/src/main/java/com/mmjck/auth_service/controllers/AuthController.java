package com.mmjck.auth_service.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.auth_service.domain.user.User;
import com.mmjck.auth_service.domain.user.exceptions.UserNotFoundException;
import com.mmjck.auth_service.dto.LoginRequestDTO;
import com.mmjck.auth_service.dto.RegisterRequestDTO;
import com.mmjck.auth_service.dto.ResponseDTO;
import com.mmjck.auth_service.infra.security.TokenService;
import com.mmjck.auth_service.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UserService userService;
    private final PasswordEncoder passwordEncoder;

    private final TokenService tokenService;

    public AuthController(UserService userService, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO requestDto){
        User user = this.userService.findByEmail(requestDto.email()).orElseThrow(() -> new UserNotFoundException());

        
        if(passwordEncoder.matches(requestDto.password(), user.getPassword())){
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok().body(new ResponseDTO(user.getName(), token));
        }


        return ResponseEntity.badRequest().build();

    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequestDTO requestDTO){
        Optional<User> findedUser = this.userService.findByEmail(requestDTO.email());

        if(findedUser == null){
            return ResponseEntity.badRequest().build();
        }

        User user = this.userService.save(requestDTO);

        String token = this.tokenService.generateToken(user);
        return ResponseEntity.ok().body(new ResponseDTO(user.getName(), token));
    }
}
