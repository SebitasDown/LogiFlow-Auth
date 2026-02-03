package com.LogiFlow.LogiFlow_Oauth.application.exception;

public class InvalidToken extends ServiceException{
    public InvalidToken(String message) {
        super(message);
    }
}
