package com.LogiFlow.LogiFlow_Oauth.application.exception;

public class InvalidCredential extends ServiceException{
    public InvalidCredential(String message) {
        super(message);
    }
}
