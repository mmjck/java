package com.mmjck.vacancy_management.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mmjck.vacancy_management.exceptions.UserFoundExecption;
import com.mmjck.vacancy_management.modules.candidate.entities.CandidateEntity;
import com.mmjck.vacancy_management.modules.candidate.repositories.CandidateRepository;



@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    
    public CandidateEntity execute(CandidateEntity entity){
        this.candidateRepository.findByUsernameOrEmail(entity.getUsername(), entity.getEmail()).ifPresent((user) ->  {
            throw new UserFoundExecption();
        });

        
        String password = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(password);
        
        return this.candidateRepository.save(entity);
    }
}
