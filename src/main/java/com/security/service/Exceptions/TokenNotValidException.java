package com.security.service.Exceptions;

public class TokenNotValidException extends RuntimeException{
    public TokenNotValidException(String message){
        super(message);
    }
}
