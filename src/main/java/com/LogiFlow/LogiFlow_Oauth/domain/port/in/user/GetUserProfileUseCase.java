package com.LogiFlow.LogiFlow_Oauth.domain.port.in.user;

import com.LogiFlow.LogiFlow_Oauth.domain.model.User;

public interface GetUserProfileUseCase {
    User execute (Long userId);
}
