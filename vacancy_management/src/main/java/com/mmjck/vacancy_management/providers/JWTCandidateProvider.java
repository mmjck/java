package com.mmjck.vacancy_management.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JWTCandidateProvider {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    public DecodedJWT validate(String tk) {
        String token = tk.replace("Bearer ", "");

        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        try {
            DecodedJWT td = JWT.require(algorithm)
            .build()
            .verify(token);

            return td;    
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
