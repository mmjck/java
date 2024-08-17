package com.uol.ms.Exceptions;

import org.springframework.http.HttpStatus;

public record ExceptionDto(
        String message,
        HttpStatus status
) {
}