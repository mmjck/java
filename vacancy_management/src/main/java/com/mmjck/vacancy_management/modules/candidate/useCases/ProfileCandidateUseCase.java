package com.mmjck.vacancy_management.modules.candidate.useCases;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mmjck.vacancy_management.modules.candidate.dto.ProfileCandidateResponseDTO;
import com.mmjck.vacancy_management.modules.candidate.entities.CandidateEntity;
import com.mmjck.vacancy_management.modules.candidate.repositories.CandidateRepository;

@Service
public class ProfileCandidateUseCase {
    
    @Autowired
    CandidateRepository repository;


    
    public ProfileCandidateResponseDTO execute(UUID id){
        CandidateEntity candidate = this.repository.findById(id).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });


        ProfileCandidateResponseDTO dto = ProfileCandidateResponseDTO
            .builder()
            .description(candidate.getDescription())
            .username(candidate.getUsername())
            .email(candidate.getEmail())
            .id(candidate.getId())
            .build();
        
        
            return dto;
    }
}
