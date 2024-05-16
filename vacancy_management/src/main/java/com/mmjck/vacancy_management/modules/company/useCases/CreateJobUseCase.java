package com.mmjck.vacancy_management.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mmjck.vacancy_management.modules.company.entities.JobEntity;
import com.mmjck.vacancy_management.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository repository;
    
    public JobEntity execute(JobEntity entity){
        return this.repository.save(entity);
    }
}
