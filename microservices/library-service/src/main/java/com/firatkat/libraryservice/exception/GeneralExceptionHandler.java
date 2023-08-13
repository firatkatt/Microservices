package com.firatkat.libraryservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(NotFoundLibraryException.class)
    public ResponseEntity<?> handle(NotFoundLibraryException notFoundLibraryException){
        return new ResponseEntity<>(notFoundLibraryException.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NotFoundBookException.class)
    public ResponseEntity<ExceptionMessage> handle(NotFoundBookException notFoundBookException){
        return new ResponseEntity<>(notFoundBookException.getExceptionMessage(), HttpStatus.resolve(notFoundBookException.getExceptionMessage().status()));
    }
}
