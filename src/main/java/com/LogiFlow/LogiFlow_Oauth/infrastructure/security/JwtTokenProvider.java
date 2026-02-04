package com.LogiFlow.LogiFlow_Oauth.infrastructure.security;

import com.LogiFlow.LogiFlow_Oauth.domain.model.User;
import com.LogiFlow.LogiFlow_Oauth.domain.port.out.TokenProvider;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider implements TokenProvider {

    // Clase que nos brinda la expiracion
    private final JwtProperties properties;


    @Override
    public String generateAccessToken(User user) {
        return createToken(user, properties.getAccessTokenExpirationMs());
    }

    @Override
    public String generateRefreshToken(User user) {
        return createToken(user, properties.getRefreshTokenExpirationMs());
    }

    // Creador de tokenp

    private String createToken(User user, long expirationMs){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expirationMs);
        Key key = Keys.hmacShaKeyFor(properties.getSecret().getBytes());

        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .claim("id", user.getId())
                .claim("email", user.getEmail())
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }
}
