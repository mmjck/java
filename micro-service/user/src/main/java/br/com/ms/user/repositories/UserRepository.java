package br.com.ms.user.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ms.user.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{    }
