package com.customer.entrypoint.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CustomerRequestDto {
    @NotBlank
    @Pattern(regexp="^[A-Za-z]*$", message = "Invalid Input")
    private String firstName;
    
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input")
    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;
} 
