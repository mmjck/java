package org.mmjck.domain.loan;

import org.mmjck.domain.customer.Customer;
import org.mmjck.domain.loan.exceptions.LoanNotAvailableException;

public class Loan {
    private final Customer customer;

    public Loan(Customer customer) {
        this.customer = customer;
    }

    public boolean isConsigmentLoanAvailable() {
        return customer.isIncomeEqualOrGreaterThan(5000.0);
    }

    public boolean isPersonalLoanAvailable() {
        return basicLoanAvailable();
    }

    public boolean isGuaranteedLoanAvailable() {
        return basicLoanAvailable();
    }

    public double getPersonalLoanInterestRate() {
        if (isPersonalLoanAvailable()){
            return 4.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getGuaranteedLoanInterestRate() {
        if (isGuaranteedLoanAvailable()){
            return 3.0;
        }
        throw new LoanNotAvailableException();
    }

    public double getConsigmentLoanInterestRate() {
        if (isConsigmentLoanAvailable()){
            return 2.0;
        }
        throw new LoanNotAvailableException();
    }

    public boolean basicLoanAvailable(){
        if(this.customer.isIncomeEqualOrLowerThan(3000.0)){
            return true;
        }


        return this.customer.isIncomeBetween(3000.0, 5000.0)
                    && this.customer.isAgeLowerThan(30)
                    && this.customer.isFromLocation("AM");
    }

}
