package org.mmjck.controller.dto;

import java.util.List;

public record CustomerLoanResponseDto(
        String customer,
        List<LoanResponse> loans
) {
}
