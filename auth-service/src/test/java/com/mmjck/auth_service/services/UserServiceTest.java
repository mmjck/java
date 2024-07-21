package com.mmjck.auth_service.services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mmjck.auth_service.domain.user.User;
import com.mmjck.auth_service.domain.user.exceptions.UserAlreadyExists;
import com.mmjck.auth_service.dto.RegisterRequestDTO;
import com.mmjck.auth_service.repositories.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;;


public class UserServiceTest {
    
    @Autowired
    @InjectMocks
    UserService userService;

    @Mock
    private UserRepository userRepository;
    
    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }
    
    @Mock
    private  PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("should be able to create user")
    void saveUser() {

        String email = "email@gmail.com";
        RegisterRequestDTO dt0 = new RegisterRequestDTO("name", email, "test123");
        

        User user = this.createUser(dt0);
        when(this.userRepository.findByEmail(email)).thenReturn(null);
        when(this.userRepository.save(any(User.class))).thenReturn(user);

        User u = this.userService.save(dt0);
        assertNotNull(u);
        assertThat(u.getEmail()).isEqualTo(email);
    }



    @Test
    @DisplayName("should not be able to create user already exists")
    void saveUserCase1() {

        String email = "email@gmail.com";
        RegisterRequestDTO dt0 = new RegisterRequestDTO("name", email, "test123");
        User user = this.createUser(dt0);



        
        when(this.userRepository.save(any(User.class))).thenReturn(user);
        this.userRepository.save(user);


        when(this.userRepository.findByEmail(email)).thenThrow(UserAlreadyExists.class);
        
        
        assertThrows(UserAlreadyExists.class, () -> {
            this.userService.save(dt0);
        });
    }



    @Test
    @DisplayName("Should be able to get user by email already created")
    void findByEmailCase1(){
        String email = "email@gmail.com";
        RegisterRequestDTO dt0 = new RegisterRequestDTO("name", email, "test123");
        

        User user = this.createUser(dt0);

        when(this.userRepository.findByEmail(email)).thenReturn(Optional.of(user));

        Optional<User> u = this.userService.findByEmail(email);
        assertNotNull(u);
        assertThat(u.get().getEmail()).isEqualTo(email);
    }


    @Test
    @DisplayName("Should be able to get user by email not created")
    void findByEmailCase2(){
        String email = "email@gmail.com";

        when(this.userRepository.findByEmail(email)).thenReturn(null);

        Optional<User> u = this.userService.findByEmail(email);
        assertNull(u);
    }
 

    private User createUser(RegisterRequestDTO dto){
        return new User("1", dto.name(), dto.password(), dto.email());
    }
}
