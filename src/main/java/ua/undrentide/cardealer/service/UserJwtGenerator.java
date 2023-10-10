package ua.undrentide.cardealer.service;

import ua.undrentide.cardealer.entity.AbstractUserEntity;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserJwtGenerator {

    @Value("${jwt.secret}")
    private String secret;
    public static final long JWT_TOKEN_VALIDITY = 1000;

    public String userJwtGenerateToken(AbstractUserEntity abstractUserEntity) {
        return Jwts.builder().setSubject(abstractUserEntity.getLogin()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
}