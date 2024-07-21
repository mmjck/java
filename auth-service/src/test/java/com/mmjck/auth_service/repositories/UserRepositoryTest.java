package com.mmjck.auth_service.repositories;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.mmjck.auth_service.domain.user.User;
import com.mmjck.auth_service.dto.RegisterRequestDTO;

import jakarta.persistence.EntityManager;
import static org.assertj.core.api.Assertions.assertThat;;

@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {
    @Autowired
    EntityManager entityManager;

    @Autowired
    UserRepository userRepository;



    @Test
    @DisplayName("should get User successfully from database")
    void findUserByDocumentSuccess() {
        String email = "email@gmail.com";
        RegisterRequestDTO dto = new RegisterRequestDTO("name", email, "teste123");
        this.createUser(dto);


        Optional<User> result = this.userRepository.findByEmail(email);

        assertThat(result.isPresent()).isTrue();

    }

    @Test
    @DisplayName("should not get User successfully from database when user not exists")
    void findUserByDocumentUserNotExists() {
        String email = "email@gmail.com";
        Optional<User> result = this.userRepository.findByEmail(email);

        assertThat(result.isEmpty()).isTrue();

    }


    private User createUser(RegisterRequestDTO dto){
        User user = new User("1", dto.name(), dto.password(), dto.email());
        this.entityManager.persist(user);
        return user;
    }
}
