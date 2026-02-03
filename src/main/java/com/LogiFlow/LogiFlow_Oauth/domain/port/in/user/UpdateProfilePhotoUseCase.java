package com.LogiFlow.LogiFlow_Oauth.domain.port.in.user;

public interface UpdateProfilePhotoUseCase {
    String uploadProfileImage (Long userId, byte[] imageBytes);
}
