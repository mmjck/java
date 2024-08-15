package org.mmjck.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.mmjck.domain.customer.Customer;

public record CustomerLoanRequestDto(

        @Min(value = 18) @NotNull Integer age,
        @CPF String cpf,
        @NotBlank String name,
        @Min(value = 1000) @NotNull Double income,
        @NotBlank String location
) {

    public Customer toCustomer(){
        return new Customer(age, name, cpf, income, location);
    }
}
