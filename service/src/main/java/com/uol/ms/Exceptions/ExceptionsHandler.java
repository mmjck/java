package com.uol.ms.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionDto> noSouchElementException(NoSuchElementException e){
        return ResponseEntity.badRequest().body(new ExceptionDto(e.getMessage(), HttpStatus.BAD_REQUEST));
    }
}
