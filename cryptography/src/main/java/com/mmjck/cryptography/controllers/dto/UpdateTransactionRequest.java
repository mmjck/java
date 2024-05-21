package com.mmjck.cryptography.controllers.dto;

import jakarta.validation.constraints.NotBlank;

public record UpdateTransactionRequest(
    @NotBlank Long value
) {
}
