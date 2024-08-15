package org.mmjck.domain.loan.exceptions;

public class LoanNotAvailableException extends  RuntimeException{
    public LoanNotAvailableException(){
        super("Loan not available");
    }
}
