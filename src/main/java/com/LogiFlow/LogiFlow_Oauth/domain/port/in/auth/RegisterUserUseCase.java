package com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth;

public interface RegisterUserUseCase {
    AuthResult register(String fullName, String email, String password);
}
