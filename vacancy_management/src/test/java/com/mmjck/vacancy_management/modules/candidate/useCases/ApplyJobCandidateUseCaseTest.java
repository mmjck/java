package com.mmjck.vacancy_management.modules.candidate.useCases;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mmjck.vacancy_management.exceptions.JobNotFoundException;
import com.mmjck.vacancy_management.exceptions.UserNotFoundException;
import com.mmjck.vacancy_management.modules.candidate.entities.CandidateEntity;
import com.mmjck.vacancy_management.modules.candidate.repositories.CandidateRepository;
import com.mmjck.vacancy_management.modules.company.repositories.JobRepository;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {
    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Should not be able to apply job with candidate not found")
    public void applyJobWithCandidateNotFound() {
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            // assertEquals(e, UserNotFoundException.class);
            assertInstanceOf(UserNotFoundException.class, e);
        }
    }

    @Test
    @DisplayName("Should not be able to apply job with not not found")
    public void applyJobWithJobNotFound() {
        UUID idCandidate = UUID.randomUUID();
        
        CandidateEntity candidate = new CandidateEntity();
        candidate.setId(idCandidate);

        when(candidateRepository
                .findById(idCandidate))
                .thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate, null);
        } catch (Exception e) {
            // assertEquals(e, UserNotFoundException.class);
            assertInstanceOf(JobNotFoundException.class, e);
        }
    }
}
