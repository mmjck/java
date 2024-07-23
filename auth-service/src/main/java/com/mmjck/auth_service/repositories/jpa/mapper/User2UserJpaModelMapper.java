package com.mmjck.auth_service.repositories.jpa.mapper;

import java.util.function.Function;

import com.mmjck.auth_service.domain.user.entity.User;
import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;

public class User2UserJpaModelMapper implements Function<User, UserJpaModel> {

    public static UserJpaModel mapper(final User user) {
        return new User2UserJpaModelMapper().apply(user);
    }

    @Override
    public UserJpaModel apply(User user) {

        return new UserJpaModel(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail());

    }

}
