package com.mmjck.auth_service.dto;

import org.springframework.http.HttpStatus;

public record ApiResponseError(
    HttpStatus error,
    String message
    ){
}
