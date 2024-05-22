package com.mmjck.vacancy_management.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mmjck.vacancy_management.exceptions.UserFoundException;
import com.mmjck.vacancy_management.modules.company.entities.CompanyEntity;
import com.mmjck.vacancy_management.modules.company.repositories.CompanyRepository;


@Service
public class CreateCompanyUseCase {
    @Autowired
    CompanyRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity entity){

        this.repository
        .findByUsernameOrEmail(entity.getUsername(), entity.getEmail())
        .ifPresent(user -> {
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(entity.getPassword());
        entity.setPassword(password);
        
        
        return this.repository.save(entity);
    }   
}
