package com.firatkat.bookservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(NotFoundBookException.class)
    public ResponseEntity<?> handle(NotFoundBookException notFoundBookException){
        return new ResponseEntity<>(notFoundBookException.getMessage(),HttpStatus.NOT_FOUND);
    }

}
