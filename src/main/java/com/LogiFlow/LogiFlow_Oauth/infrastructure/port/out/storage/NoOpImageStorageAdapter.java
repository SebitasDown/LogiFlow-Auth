package com.LogiFlow.LogiFlow_Oauth.infrastructure.port.out.storage;

import com.LogiFlow.LogiFlow_Oauth.domain.port.out.ImageStoragePort;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Implementación stub de ImageStoragePort para que la aplicación arranque.
 * Sustituir por un adaptador real (S3, almacenamiento local, etc.) cuando se implemente.
 */
@Component
@Primary
public class NoOpImageStorageAdapter implements ImageStoragePort {

    @Override
    public String uploadProfileImage(byte[] imagesBytes) {
        return "placeholder://profile-photo";
    }
}
