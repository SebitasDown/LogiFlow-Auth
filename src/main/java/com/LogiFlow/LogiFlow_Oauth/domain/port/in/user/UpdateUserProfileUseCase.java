package com.LogiFlow.LogiFlow_Oauth.domain.port.in.user;

import com.LogiFlow.LogiFlow_Oauth.domain.model.Role;
import com.LogiFlow.LogiFlow_Oauth.domain.model.Status;
import com.LogiFlow.LogiFlow_Oauth.domain.model.User;

public interface UpdateUserProfileUseCase {
    User updateProfile (
    Long userId,
     String fullName,
     String email,
     String password,
     Role role,
     Integer activeShipment,
     String avatarUrl,
     String avatarColor,
     Status status
    );
}
