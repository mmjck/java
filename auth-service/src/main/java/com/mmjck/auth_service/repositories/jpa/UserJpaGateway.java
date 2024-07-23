package com.mmjck.auth_service.repositories.jpa;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.mmjck.auth_service.domain.user.entity.User;
import com.mmjck.auth_service.domain.user.gateway.UserGateway;
import com.mmjck.auth_service.repositories.UserJpaRepository;
import com.mmjck.auth_service.repositories.jpa.mapper.User2UserJpaModelMapper;
import com.mmjck.auth_service.repositories.jpa.mapper.UserJpaModel2UserMapper;
import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;


@Component
public class UserJpaGateway implements UserGateway{
    private final UserJpaRepository repository;

    public UserJpaGateway(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        UserJpaModel entity = User2UserJpaModelMapper.mapper(user);
        return  UserJpaModel2UserMapper.mapper(this.repository.save(entity));
    }

    @Override
    public User findByEmail(String email) {
        Optional<UserJpaModel> entity = this.repository.findByEmail(email);

        if(!entity.isPresent()){
            return null;
        }
        return UserJpaModel2UserMapper.mapper(entity.get());
    }
    
}
