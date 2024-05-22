package com.mmjck.vacancy_management.modules.candidate.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mmjck.vacancy_management.modules.candidate.entities.CandidateEntity;
import com.mmjck.vacancy_management.modules.candidate.useCases.ApplyJobCandidateUseCase;
import com.mmjck.vacancy_management.modules.candidate.useCases.CreateCandidateUseCase;
import com.mmjck.vacancy_management.modules.candidate.useCases.ProfileCandidateUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Autowired
    ProfileCandidateUseCase profileCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity entity) {
        try {
            var result = this.createCandidateUseCase.execute(entity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> profile(HttpServletRequest request) {
        Object id = request.getAttribute("candidate_id");

        try {
            var result = this.profileCandidateUseCase.execute(UUID.fromString(id.toString()));
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/apply-job")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> applyJob(
            HttpServletRequest request,
            @RequestBody UUID idJob) {
        Object candidateId = request.getAttribute("candidate_id");

        try {
            var response = this.applyJobCandidateUseCase.execute(UUID.fromString(candidateId.toString()), idJob);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.ok().body(e.getMessage());

        }

    }

}
