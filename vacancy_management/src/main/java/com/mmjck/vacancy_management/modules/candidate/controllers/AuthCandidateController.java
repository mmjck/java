package com.mmjck.vacancy_management.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.vacancy_management.modules.candidate.dto.AuthCandidateRequestDTO;
import com.mmjck.vacancy_management.modules.candidate.dto.AuthCandidateResponseDTO;
import com.mmjck.vacancy_management.modules.candidate.useCases.AuthCandidateUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/candidate")
public class AuthCandidateController {
    @Autowired
    private AuthCandidateUseCase useCase;

    @PostMapping("/auth/")
    public ResponseEntity<Object> create(@RequestBody AuthCandidateRequestDTO dto) {
        try {
            AuthCandidateResponseDTO token = this.useCase.execute(dto);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status( HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
    
}
