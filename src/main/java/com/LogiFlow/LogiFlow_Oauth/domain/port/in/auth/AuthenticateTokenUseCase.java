package com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth;

public interface AuthenticateTokenUseCase {
    UserSession execute(String token);
}
