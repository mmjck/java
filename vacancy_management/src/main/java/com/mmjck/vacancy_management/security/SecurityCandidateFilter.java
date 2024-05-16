package com.mmjck.vacancy_management.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.mmjck.vacancy_management.providers.JWTCandidateProvider;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityCandidateFilter extends OncePerRequestFilter {
    @Autowired
    JWTCandidateProvider jwtCandidateProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // SecurityContextHolder.getContext().setAuthentication(null);

        String token = request.getHeader("Authorization");

        if (request.getRequestURI().startsWith("/candidate")) {

            if (token != null) {
                DecodedJWT t = jwtCandidateProvider.validate(token);

                if (t == null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }

                request.setAttribute("candidate_id", t.getSubject());
                var roles = t.getClaim("roles").asList(Object.class);

                var grants = roles
                    .stream()
                    .map((role) ->  new SimpleGrantedAuthority("ROLE_" + role.toString().toUpperCase()))
                    .toList();

                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(t.getSubject(), null, grants);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }
}
