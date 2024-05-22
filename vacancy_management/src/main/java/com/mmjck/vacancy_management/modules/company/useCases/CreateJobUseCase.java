package com.mmjck.vacancy_management.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmjck.vacancy_management.exceptions.CompanyNotFoundException;
import com.mmjck.vacancy_management.modules.company.entities.JobEntity;
import com.mmjck.vacancy_management.modules.company.repositories.CompanyRepository;
import com.mmjck.vacancy_management.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository repository;
    
    @Autowired
    CompanyRepository companyRepository;


    public JobEntity execute(JobEntity entity){
        companyRepository.findById(entity.getCompanyId()).orElseThrow(() -> {
            throw new CompanyNotFoundException();
        });
        return this.repository.save(entity);
    }
}
