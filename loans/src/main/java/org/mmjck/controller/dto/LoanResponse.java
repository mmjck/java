package org.mmjck.controller.dto;

import org.mmjck.domain.loan.LoanType;

public record LoanResponse(LoanType type, Double interestRate) {
}
