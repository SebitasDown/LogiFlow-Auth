package com.LogiFlow.LogiFlow_Oauth.domain.port.out;

import com.LogiFlow.LogiFlow_Oauth.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long userId);
    Optional<User> findByEmail(String email);
}
