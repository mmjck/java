package com.mmjck.auth_service.domain.user.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mmjck.auth_service.dto.ApiResponseError;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception){
        return ResponseEntity.badRequest().body(new ApiResponseError(exception.getMessage()));

    }


    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<Object> handleUserAlreadyExists(UserAlreadyExists exception){
        return ResponseEntity.badRequest().body(new ApiResponseError(exception.getMessage()));

    }
}
