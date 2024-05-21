package com.mmjck.cryptography.controllers.dto;

public record CreateTransactionRequest(
    String userDocument,
    String creditCardToken,
    Long value
) {
}
