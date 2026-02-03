package com.LogiFlow.LogiFlow_Oauth.domain.port.out;

public interface PasswordHasher {
    String hash(String password);
    boolean matches(String password, String hashedPassword);
}
