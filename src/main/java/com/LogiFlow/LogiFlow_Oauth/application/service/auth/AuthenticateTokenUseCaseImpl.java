package com.LogiFlow.LogiFlow_Oauth.application.service.auth;

import com.LogiFlow.LogiFlow_Oauth.application.exception.InvalidParam;
import com.LogiFlow.LogiFlow_Oauth.application.exception.InvalidToken;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth.AuthenticateTokenUseCase;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth.UserSession;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.TokenValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AuthenticateTokenUseCaseImpl implements AuthenticateTokenUseCase {

    private final TokenValidator tokenValidator;

    public AuthenticateTokenUseCaseImpl(TokenValidator tokenValidator) {
        this.tokenValidator = tokenValidator;
    }

    @Override
    public UserSession execute(String token) {
        if (token == null || token.isBlank()){
            log.warn("Token vacio o nulo");
            throw  new InvalidToken("Token vacio");
        }

        if(!tokenValidator.isValid(token)){
            log.warn("El token no es valido");
            throw new InvalidToken("Token invalido");
        }

        Long userId = tokenValidator.extractUserId(token)
                .orElseThrow(() -> new InvalidParam("Parametro desconocido"));

        String email = tokenValidator.extractEmail(token)
                .orElse("unknown");

        return new UserSession(userId, email);
    }
}
