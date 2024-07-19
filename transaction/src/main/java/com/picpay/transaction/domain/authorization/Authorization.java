package com.picpay.transaction.domain.authorization;

public record Authorization(
    String message
) {
    public boolean isAuthorized(){
        return message.equals("Autorizado");
    }
}
