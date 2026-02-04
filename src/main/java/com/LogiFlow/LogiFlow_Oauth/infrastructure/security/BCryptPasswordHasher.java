package com.LogiFlow.LogiFlow_Oauth.infrastructure.security;

import com.LogiFlow.LogiFlow_Oauth.domain.port.out.PasswordHasher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BCryptPasswordHasher implements PasswordHasher {

    private final BCryptPasswordHasher encoder;

    @Override
    public String hash(String password) {
        return encoder.hash(password);
    }

    @Override
    public boolean matches(String password, String hashedPassword) {
        return encoder.matches(password, hashedPassword);
    }
}
