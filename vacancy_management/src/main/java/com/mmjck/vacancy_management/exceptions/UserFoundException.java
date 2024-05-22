package com.mmjck.vacancy_management.exceptions;

public class UserFoundException extends RuntimeException{
    public UserFoundException(){
        super("User already exists");
    }
}
