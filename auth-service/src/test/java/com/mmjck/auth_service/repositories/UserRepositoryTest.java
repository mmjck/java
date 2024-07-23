package com.mmjck.auth_service.repositories;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;

import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    UserJpaRepository repository;



    @Test
    @DisplayName("should get User successfully from database")
    void findUserByDocumentSuccess() {
        String email = "email@gmail.com";
        
        Optional<UserJpaModel> result = this.repository.findByEmail(email);

        assertThat(result.isPresent()).isTrue();

    }

    @Test
    @DisplayName("should not get User successfully from database when user not exists")
    void findUserByDocumentUserNotExists() {
        String email = "email@gmail.com";

        when(this.repository.findByEmail(email)).thenReturn(null);
        Optional<UserJpaModel> result = this.repository.findByEmail(email);

        assertThat(result.isEmpty()).isTrue();

    }

}
