package com.mmjck.vacancy_management.providers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

@Service
public class JWTProvider {
    @Value("${security.token.secret}")
    private String secretKey; 


    public DecodedJWT validate(String token){
        String v = token.replace("Bearer ", "");


        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        try {
            DecodedJWT tokenDecoded = JWT.require(algorithm)
            .build()
            .verify(v);

            return tokenDecoded;
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
