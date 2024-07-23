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

import com.mmjck.auth_service.domain.user.entity.User;
import com.mmjck.auth_service.domain.user.gateway.UserGateway;
import com.mmjck.auth_service.dto.RegisterRequestDTO;
import com.mmjck.auth_service.repositories.UserJpaRepository;
import com.mmjck.auth_service.repositories.jpa.mapper.User2UserJpaModelMapper;
import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;
import com.mmjck.auth_service.services.impl.UserServiceImplementation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;;


public class UserServiceTest {
    

    //  private final UserJpaRepository repository;
    // private final PasswordEncoder passwordEncoder;
    // private final UserGateway userGateway;


    
    @Autowired
    @InjectMocks
    UserServiceImplementation userService;

    @Mock
    private UserJpaRepository userRepository;
    
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
        when(this.userRepository.save(any(UserJpaModel.class))).thenReturn(User2UserJpaModelMapper.mapper(user));

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



        
        when(this.userRepository.save(any(UserJpaModel.class))).thenReturn(User2UserJpaModelMapper.mapper(user));
        this.userRepository.save(User2UserJpaModelMapper.mapper(user));


        when(this.userRepository.findByEmail(email)).thenReturn(null);
        
        
        // assertThat(
        //     this.userService.save(dt0)
        // );
    }



    // @Test
    // @DisplayName("Should be able to get user by email already created")
    // void findByEmailCase1(){
    //     String email = "email@gmail.com";
    //     RegisterRequestDTO dt0 = new RegisterRequestDTO("name", email, "test123");
        

    //     User user = this.createUser(dt0);

    //     when(this.userRepository.findByEmail(email)).thenReturn(Optional.of(user));

    //     Optional<User> u = this.userService.findByEmail(email);
    //     assertNotNull(u);
    //     assertThat(u.get().getEmail()).isEqualTo(email);
    // }


    // @Test
    // @DisplayName("Should be able to get user by email not created")
    // void findByEmailCase2(){
    //     String email = "email@gmail.com";

    //     when(this.userRepository.findByEmail(email)).thenReturn(null);

    //     Optional<User> u = this.userService.findByEmail(email);
    //     assertNull(u);
    // }
 

    private User createUser(RegisterRequestDTO dto){
        return User.with("1", dto.name(), dto.password(), dto.email());
    }
}
