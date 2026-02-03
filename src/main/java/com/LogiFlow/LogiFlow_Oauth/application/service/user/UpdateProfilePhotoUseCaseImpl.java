package com.LogiFlow.LogiFlow_Oauth.application.service.user;

import com.LogiFlow.LogiFlow_Oauth.application.exception.NotFound;
import com.LogiFlow.LogiFlow_Oauth.domain.model.User;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.user.UpdateProfilePhotoUseCase;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.ImageStoragePort;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateProfilePhotoUseCaseImpl implements UpdateProfilePhotoUseCase {

    private final UserRepository userRepository;
    private final ImageStoragePort imageStoragePort;

    public UpdateProfilePhotoUseCaseImpl(UserRepository userRepository, ImageStoragePort imageStoragePort) {
        this.userRepository = userRepository;
        this.imageStoragePort = imageStoragePort;
    }

    @Override
    public String uploadProfileImage(Long userId, byte[] imageBytes) {
        User user = userRepository.findById(userId)
                .orElseThrow( () -> new NotFound("Usuario no encontrado"));

        String imageUrl = imageStoragePort.uploadProfileImage(imageBytes);

        user.updateProfilePhoto(imageUrl);

        userRepository.save(user);

        return imageUrl;
    }
}
