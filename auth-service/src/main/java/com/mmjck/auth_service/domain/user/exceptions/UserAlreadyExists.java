package com.mmjck.auth_service.domain.user.exceptions;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(){
        super("User already exists");
    }
}
