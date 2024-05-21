package com.mmjck.cryptography.controllers.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTransactionRequest(
    @NotBlank String userDocument,
    @NotBlank String creditCardToken,
    @NotNull Long transactionValue
) {
}
