package com.firatkat.libraryservice.exception;

public class NotFoundBookException extends RuntimeException{
    public ExceptionMessage exceptionMessage;
    public NotFoundBookException(String message){
        super(message);
    }
    public NotFoundBookException(String message,ExceptionMessage exceptionMessage){
        super(message);
        this.exceptionMessage = exceptionMessage;
    }
    public NotFoundBookException(ExceptionMessage exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }
    public ExceptionMessage getExceptionMessage(){
        return exceptionMessage;
    }
}
