package com.firatkat.bookservice.exception;

public class NotFoundBookException extends RuntimeException{
    public NotFoundBookException(String s) {
        super(s);
    }
}
