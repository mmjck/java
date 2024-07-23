package com.mmjck.auth_service.infra.security;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.mmjck.auth_service.domain.user.exceptions.UserNotFoundException;
import com.mmjck.auth_service.repositories.UserJpaRepository;
import com.mmjck.auth_service.repositories.jpa.mapper.UserJpaModel2UserMapper;
import com.mmjck.auth_service.repositories.jpa.model.UserJpaModel;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private TokenService tokenService;

    private UserJpaRepository userRepository;

    public SecurityFilter(TokenService tokenService, UserJpaRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var token = this.recoverToken(request);
        var login = tokenService.validateToken(token);

        if (login != null) {
            UserJpaModel user = userRepository.findByEmail(login).orElseThrow(() -> new UserNotFoundException());

            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var authentication = new UsernamePasswordAuthenticationToken(UserJpaModel2UserMapper.expose(user), null,
                    authorities);

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization");

        if (header == null) {
            return null;
        }

        return header.replace("Bearer ", "");
    }
}
