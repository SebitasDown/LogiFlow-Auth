package com.LogiFlow.LogiFlow_Oauth.infrastructure.port.in.web.mapper;

import com.LogiFlow.LogiFlow_Oauth.domain.port.in.auth.AuthResult;
import com.LogiFlow.LogiFlow_Oauth.infrastructure.port.in.web.dto.response.AuthResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthDtoMapper {
    AuthResponse toDto(AuthResult authResult);
}
