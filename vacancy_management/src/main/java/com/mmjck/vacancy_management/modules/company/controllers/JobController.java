package com.mmjck.vacancy_management.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mmjck.vacancy_management.modules.company.dto.CreateJobDTO;
import com.mmjck.vacancy_management.modules.company.entities.JobEntity;
import com.mmjck.vacancy_management.modules.company.useCases.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobUseCase useCase;

    @PostMapping("/")
    @PreAuthorize("hasRole('COMPANY')")
    public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO dto, HttpServletRequest request){
        Object companyId = request.getAttribute("company_id");
            try {
                JobEntity job = JobEntity.builder()
                        .companyId(UUID.fromString(companyId.toString()))
                        .benefits(dto.getBenefits())    
                        .description(dto.getDescription())
                        .level(dto.getLevel())
                        .build();    
                
                        var result =  this.useCase.execute(job);
                return ResponseEntity.ok().body(result);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }

        
        
        
    }
}
