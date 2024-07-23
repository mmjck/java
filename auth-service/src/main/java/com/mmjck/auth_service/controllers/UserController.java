package com.mmjck.auth_service.controllers;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.auth_service.domain.user.entity.User;
import com.mmjck.auth_service.dto.GetMeDtoResponse;
import com.mmjck.auth_service.services.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    
    private final UserService userService;


	public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
	public ResponseEntity<GetMeDtoResponse>  home(Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User)authentication.getPrincipal();

        var response = this.userService.findByEmail(currentUser.getEmail());
        return ResponseEntity.ok().body(new GetMeDtoResponse(response.getId(), response.getName(), response.getEmail()));

	}
}
