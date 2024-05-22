package com.mmjck.vacancy_management.modules.candidate.useCases;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mmjck.vacancy_management.exceptions.UserNotFoundException;
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
    public void applyJobWithCandidateNotFound(){
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            // assertEquals(e, UserNotFoundException.class);
            assertInstanceOf(UserNotFoundException.class, e);
        }
    }
}
