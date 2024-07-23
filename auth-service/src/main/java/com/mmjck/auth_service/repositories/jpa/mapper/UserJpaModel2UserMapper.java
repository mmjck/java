package com.mmjck.auth_service.repositories.jpa.mapper;

import com.mmjck.auth_service.domain.user.entity.User;
import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;

import java.util.function.Function;

public class UserJpaModel2UserMapper implements Function<UserJpaModel, User> {
    public static User mapper(final UserJpaModel user) {
        return new UserJpaModel2UserMapper().apply(user);
    }

    public static User expose(final UserJpaModel user) {
        return new UserJpaModel2UserMapper().applyWithoutPassword(user);
    }

    @Override
    public User apply(UserJpaModel user) {
        return User.with(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getEmail());

    }

    public User applyWithoutPassword(UserJpaModel user) {
        return User.expose(
                user.getId(),
                user.getName(),
                user.getEmail());

    }

}
