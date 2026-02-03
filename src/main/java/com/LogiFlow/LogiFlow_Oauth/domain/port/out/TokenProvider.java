package com.LogiFlow.LogiFlow_Oauth.domain.port.out;

import com.LogiFlow.LogiFlow_Oauth.domain.model.User;

public interface TokenProvider {
    String generateAccessToken(User user);

    String generateRefreshToken(User user);
}
