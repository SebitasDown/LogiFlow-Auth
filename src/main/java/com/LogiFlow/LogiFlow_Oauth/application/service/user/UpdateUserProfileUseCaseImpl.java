package com.LogiFlow.LogiFlow_Oauth.application.service.user;

import com.LogiFlow.LogiFlow_Oauth.application.exception.NotFound;
import com.LogiFlow.LogiFlow_Oauth.domain.model.Role;
import com.LogiFlow.LogiFlow_Oauth.domain.model.Status;
import com.LogiFlow.LogiFlow_Oauth.domain.model.User;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.user.UpdateUserProfileUseCase;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserProfileUseCaseImpl implements UpdateUserProfileUseCase {

    private final UserRepository userRepository;

    public UpdateUserProfileUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public User updateProfile(Long userId, String fullName, String email, String password, Role role, Integer activeShipment, String avatarUrl, String avatarColor, Status status) {
        User user  = userRepository.findById(userId)
                .orElseThrow(() -> new NotFound("Usuario no encontrado"));

        user.updateProfile(fullName, email, password, role, activeShipment, avatarUrl, avatarColor, status);

        return userRepository.save(user);

    }
}
