package com.mmjck.vacancy_management.modules.company.useCases;

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
import com.mmjck.vacancy_management.modules.company.dto.AuthCompanyDTO;
import com.mmjck.vacancy_management.modules.company.dto.AuthCompanyResponseDTO;
import com.mmjck.vacancy_management.modules.company.repositories.CompanyRepository;


@Service
public class AuthCompanyUseCase {
    @Autowired
    private CompanyRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Value("${security.token.secret}")
    private String secretKey; 

    public AuthCompanyResponseDTO execute(AuthCompanyDTO dto) throws AuthenticationException {
        System.out.println(dto.toString());
        var company = this.repository.findByUsername(dto.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Username/password incorrect");
        });

        var matches = this.passwordEncoder.matches(dto.getPassword(), company.getPassword());
        if (!matches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofHours(2));
        
        String token = JWT.create()
            .withIssuer("javagas")
            .withExpiresAt(expiresIn)
            .withSubject(company.getId().toString())
            .withClaim("roles", Arrays.asList("COMPANY"))
            .sign(algorithm);

        var dtoResponse = AuthCompanyResponseDTO.builder()
            .access_token(token)    
            .expires_in(expiresIn.toEpochMilli())
            .build();
        
        
        return dtoResponse;
    }
}
