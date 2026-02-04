package com.LogiFlow.LogiFlow_Oauth.infrastructure.port.out.persistence.adapter;

import com.LogiFlow.LogiFlow_Oauth.domain.model.User;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.UserRepository;
import com.LogiFlow.LogiFlow_Oauth.infrastructure.port.out.persistence.entity.UserEntity;
import com.LogiFlow.LogiFlow_Oauth.infrastructure.port.out.persistence.mapper.UserMapper;
import com.LogiFlow.LogiFlow_Oauth.infrastructure.port.out.persistence.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserAdapter implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        UserEntity entity = userMapper.toEntity(user);
        UserEntity savedEntity = jpaUserRepository.save(entity);
        return userMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return jpaUserRepository.findById(userId)
                .map(userMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email)
                .map(userMapper::toDomain);
    }
}
