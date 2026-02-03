package com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth;

public interface LoginUserUseCase {

    AuthResult login(String email, String password);
}
