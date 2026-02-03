package com.LogiFlow.LogiFlow_Oauth.application.service.user;

import com.LogiFlow.LogiFlow_Oauth.application.exception.NotFound;
import com.LogiFlow.LogiFlow_Oauth.domain.model.User;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.user.GetUserProfileUseCase;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserProfileUseCaseImpl implements GetUserProfileUseCase {

    private final UserRepository userRepository;

    public GetUserProfileUseCaseImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User execute(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow( () -> new NotFound("Usuario no encontrado"));
    }
}
