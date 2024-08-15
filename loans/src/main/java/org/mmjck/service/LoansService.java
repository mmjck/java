package org.mmjck.service;

import org.mmjck.controller.dto.CustomerLoanRequestDto;
import org.mmjck.controller.dto.LoanResponse;
import org.mmjck.domain.customer.Customer;
import org.mmjck.domain.loan.Loan;
import org.mmjck.domain.loan.LoanType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoansService {
    public  List<LoanResponse> checkAvailables(CustomerLoanRequestDto dto){

        List<LoanResponse> loans = new ArrayList<>();
        Customer c = dto.toCustomer();

        var loan = new Loan(c);

        if (loan.isPersonalLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.PERSONAL, loan.getPersonalLoanInterestRate()));
        }

        if (loan.isConsigmentLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.CONSIGNMENT, loan.getConsigmentLoanInterestRate()));
        }

        if (loan.isGuaranteedLoanAvailable()) {
            loans.add(new LoanResponse(LoanType.GUARANTEED, loan.getGuaranteedLoanInterestRate()));
        }

        return loans;

    }
}
