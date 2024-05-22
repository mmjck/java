package com.mmjck.vacancy_management.modules.candidate.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmjck.vacancy_management.modules.candidate.entities.CandidateEntity;
import java.util.List;




public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
   Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
   Optional<CandidateEntity> findByUsername(String username);
}
