package com.mmjck.auth_service.domain.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mmjck.auth_service.dto.ApiResponseError;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseError> handleUserNotFoundException(UserNotFoundException exception){
        return ResponseEntity.badRequest().body(new ApiResponseError(HttpStatus.BAD_REQUEST, exception.getMessage()));

    }


    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponseError> handleUserAlreadyExistsException(UserAlreadyExistsException exception){
        return ResponseEntity.badRequest().body(new ApiResponseError(HttpStatus.BAD_REQUEST, exception.getMessage()));

    }
}
