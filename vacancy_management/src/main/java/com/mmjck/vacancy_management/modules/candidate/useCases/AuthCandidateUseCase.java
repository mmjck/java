package com.mmjck.vacancy_management.modules.candidate.useCases;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mmjck.vacancy_management.modules.candidate.dto.AuthCandidateRequestDTO;
import com.mmjck.vacancy_management.modules.candidate.dto.AuthCandidateResponseDTO;
import com.mmjck.vacancy_management.modules.candidate.entities.CandidateEntity;
import com.mmjck.vacancy_management.modules.candidate.repositories.CandidateRepository;

@Service
public class AuthCandidateUseCase {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    CandidateRepository repository;    
    
    @Value("${security.token.secret.candidate}")
    private String secretKey;  

    public AuthCandidateResponseDTO execute(AuthCandidateRequestDTO dto) throws AuthenticationException{

        CandidateEntity candidate = this.repository.findByUsername(dto.username())
            .orElseThrow(() -> {
                throw new UsernameNotFoundException("Username/password incorrect");
            }); 

        boolean matches = this.passwordEncoder.matches(dto.password(), candidate.getPassword());

        if(!matches){
            throw new AuthenticationException();
        }


        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        Instant expiresIn = Instant.now().plus(Duration.ofMinutes(20));
        
        
        String token = JWT.create()
            .withIssuer("javagas")
            .withSubject(candidate.getId().toString())
            .withClaim("roles", Arrays.asList("CANDIDATE"))
            .withExpiresAt(expiresIn)
            .sign(algorithm);

        AuthCandidateResponseDTO data = AuthCandidateResponseDTO.builder()
        .access_token(token)
        .expires_in(expiresIn.toEpochMilli())
        .build();

        return data;
    }
}
