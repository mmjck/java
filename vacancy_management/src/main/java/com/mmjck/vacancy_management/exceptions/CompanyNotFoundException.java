package com.mmjck.vacancy_management.exceptions;


public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException(){
        super("Company not found");
    }
}
