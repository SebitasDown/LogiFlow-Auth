package com.LogiFlow.LogiFlow_Oauth.application.service.auth;

import com.LogiFlow.LogiFlow_Oauth.application.exception.AlreadyExist;
import com.LogiFlow.LogiFlow_Oauth.domain.model.Role;
import com.LogiFlow.LogiFlow_Oauth.domain.model.Status;
import com.LogiFlow.LogiFlow_Oauth.domain.model.User;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth.AuthResult;
import com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth.RegisterUserUseCase;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.PasswordHasher;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.TokenProvider;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Slf4j
public class RegisterUserUseCaseImpl implements RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordHasher passwordHasher;
    private final TokenProvider tokenProvider;

    public RegisterUserUseCaseImpl(UserRepository userRepository, PasswordHasher passwordHasher, TokenProvider tokenProvider) {
        this.userRepository = userRepository;
        this.passwordHasher = passwordHasher;
        this.tokenProvider = tokenProvider;
    }
    // todo: Refactorizar
    private static final List<String> AVATAR_COLORS = List.of(
            "#FF6B6B",
            "#4D96FF",
            "#6BCB77",
            "#FFD93D",
            "#845EC2"
    );

    private String generateRandomAvatarColor() {
        return AVATAR_COLORS.get(
                ThreadLocalRandom.current().nextInt(AVATAR_COLORS.size())
        );
    }

    @Override
    public AuthResult register(String fullName, String email, String password) {


        // Buscar email
        userRepository.findByEmail(email)
                .ifPresent( user->{
                    log.warn("Email en uso intente con otro");
                    throw new AlreadyExist("Este email ya esta en uso");
                });

        String passwordHash = passwordHasher.hash(password);

        String avatarColor = generateRandomAvatarColor();
        User user = new User();
        user.setEmail(email);
        user.setFullName(fullName);
        user.setPassword(passwordHash);
        user.setRole(Role.CUSTOMER);

        // ToDo: Actualizar este Shipments segun los registrados hacer llamado a la API: Preguntar a IA
        user.setActiveShipment(0);

        user.setStatus(Status.ACTIVE);
        user.setAvatarColor(avatarColor);

        User savedUser = userRepository.save(user);

        String accessToken = tokenProvider.generateAccessToken(user);
        String refreshToken = tokenProvider.generateRefreshToken(user);

        return new AuthResult(accessToken, refreshToken);
    }
}
