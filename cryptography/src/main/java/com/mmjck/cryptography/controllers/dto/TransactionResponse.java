package com.mmjck.cryptography.controllers.dto;

import com.mmjck.cryptography.entities.TransactionEntity;

public record TransactionResponse(
    Long id,
    String userDocument,
    String creditCardToken,
    Long value
) {
    public static TransactionResponse fromEntity(TransactionEntity entity){
        return new TransactionResponse(
            entity.getId(), 
            entity.getRawUserDocument(),
            entity.getEncryptedCreditCardToken(),
            entity.getTransactionValue()
        );
    }
}
