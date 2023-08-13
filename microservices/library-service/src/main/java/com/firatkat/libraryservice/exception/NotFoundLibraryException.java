package com.firatkat.libraryservice.exception;

public class NotFoundLibraryException extends RuntimeException{
    public NotFoundLibraryException(String message){
        super(message);
    }
}
