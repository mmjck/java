package com.mmjck.auth_service.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;

public interface UserJpaRepository extends JpaRepository<UserJpaModel, String>{
    Optional<UserJpaModel> findByEmail(String email);
}
