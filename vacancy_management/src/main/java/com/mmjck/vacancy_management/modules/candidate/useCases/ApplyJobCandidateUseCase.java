package com.mmjck.vacancy_management.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmjck.vacancy_management.exceptions.JobNotFoundException;
import com.mmjck.vacancy_management.exceptions.UserNotFoundException;
import com.mmjck.vacancy_management.modules.candidate.entities.ApplyJobEntity;
import com.mmjck.vacancy_management.modules.candidate.repositories.ApplyJobRepository;
import com.mmjck.vacancy_management.modules.candidate.repositories.CandidateRepository;
import com.mmjck.vacancy_management.modules.company.repositories.JobRepository;

@Service
public class ApplyJobCandidateUseCase {
    
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    public ApplyJobEntity execute(UUID candidateId, UUID jobID){

        this.candidateRepository.findById(candidateId)
            .orElseThrow(() -> {
                throw new UserNotFoundException();
        });

        this.jobRepository.findById(jobID)
            .orElseThrow(() -> {
                throw new JobNotFoundException();
            });

        var applyJob = ApplyJobEntity.builder()
            .candidateId(candidateId)
            .jobId(jobID)
            .build();
            
        var response = applyJobRepository.save(applyJob);   
        return response;
    }   
}
