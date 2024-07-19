package com.picpay.transaction.domain.authorization;

public class UnauthorizedTransactionException extends RuntimeException{
     public UnauthorizedTransactionException(String message){
        super(message);
     }
    
}
