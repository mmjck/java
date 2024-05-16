package com.mmjck.vacancy_management.exceptions;

public class UserFoundExecption extends RuntimeException{
    public UserFoundExecption(){
        super("User already exists");
    }
}
