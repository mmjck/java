package com.mmjck.auth_service.infra.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.mmjck.auth_service.repositories.UserJpaRepository;
import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;

@Component
public class CustomUserDetailsService implements UserDetailsService{

    private UserJpaRepository userRepository;

    public CustomUserDetailsService(UserJpaRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserJpaModel user = this.userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not Found"));
        


        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
    
}
