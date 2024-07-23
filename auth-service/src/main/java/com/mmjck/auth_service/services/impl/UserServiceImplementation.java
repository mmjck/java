package com.mmjck.auth_service.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mmjck.auth_service.domain.user.entity.User;
import com.mmjck.auth_service.domain.user.exceptions.UserAlreadyExistsException;

import com.mmjck.auth_service.domain.user.gateway.UserGateway;
import com.mmjck.auth_service.dto.RegisterRequestDTO;
import com.mmjck.auth_service.repositories.UserJpaRepository;
import com.mmjck.auth_service.repositories.jpa.mapper.UserJpaModel2UserMapper;
import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;
import com.mmjck.auth_service.services.UserService;

@Service
public class UserServiceImplementation implements UserService {

    private final UserJpaRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserGateway userGateway;

    private static final Logger LOGGER =
    LoggerFactory.getLogger(UserServiceImplementation.class);

    public UserServiceImplementation(
            UserJpaRepository repository,
            PasswordEncoder passwordEncoder,
            UserGateway userGateway) {

                
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.userGateway = userGateway;
    }

    @Override
    public User save(RegisterRequestDTO requestDTO) {
        User findedUser = this.userGateway.findByEmail(requestDTO.email());

        if(findedUser != null){
            throw new UserAlreadyExistsException();
        }

        User user = User.build(requestDTO.name(), passwordEncoder.encode(requestDTO.password()), requestDTO.email());

        var response = this.userGateway.save(user);
        return response;

    }

    @Override
    public User findByEmail(String email) {
        Optional<UserJpaModel> user = this.repository.findByEmail(email);

        if(!user.isPresent()){
            return null;
        }
        return UserJpaModel2UserMapper.mapper(user.get());
    }
}
