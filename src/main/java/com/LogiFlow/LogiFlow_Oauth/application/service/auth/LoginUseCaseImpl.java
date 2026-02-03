package com.LogiFlow.LogiFlow_Oauth.application.service.auth;

import com.LogiFlow.LogiFlow_Oauth.application.exception.InvalidCredential;
import com.LogiFlow.LogiFlow_Oauth.domain.model.User;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth.AuthResult;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth.LoginUserUseCase;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.PasswordHasher;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.TokenProvider;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginUseCaseImpl implements LoginUserUseCase {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final TokenProvider tokenProvider;

    public LoginUseCaseImpl(UserRepository userRepository, PasswordHasher passwordHasher, TokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
        this.tokenProvider = tokenProvider;
    }

    @Override
    public AuthResult login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new InvalidCredential("Acceso Invalido"));

        if (!passwordHasher.matches(password, user.getPassword())){
            log.warn("Acceso denegado");
            throw new InvalidCredential("Acceso invalido");
        }

        String accessToken = tokenProvider.generateAccessToken(user);
        String refreshToken = tokenProvider.generateRefreshToken(user);
        return new AuthResult(accessToken, refreshToken);
    }
}
