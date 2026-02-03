package com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth;

public class UserSession {
    private final Long userId;
    private final String email;

    public UserSession(Long userId, String email) {
        this.userId = userId;
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }
}
