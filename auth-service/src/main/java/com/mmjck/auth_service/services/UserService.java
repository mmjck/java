package com.mmjck.auth_service.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mmjck.auth_service.domain.user.User;
import com.mmjck.auth_service.domain.user.exceptions.UserAlreadyExists;
import com.mmjck.auth_service.dto.RegisterRequestDTO;
import com.mmjck.auth_service.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);



    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    public User save(RegisterRequestDTO requestDTO){
        Optional<User> findedUser = this.repository.findByEmail(requestDTO.email());

        if(findedUser != null){
            throw new UserAlreadyExists();
        }
         

        LOGGER.info("validating transaction .........");
        User user = new User();
        user.setPassword(passwordEncoder.encode(requestDTO.password()));
        user.setEmail(requestDTO.email());
        user.setName(requestDTO.name());
        
        return this.repository.save(user);
    }

    public Optional<User> findByEmail(String email){
        return this.repository.findByEmail(email);
    }
}
