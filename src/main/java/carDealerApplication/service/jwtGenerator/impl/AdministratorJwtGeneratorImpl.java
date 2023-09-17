package carDealerApplication.service.jwtGenerator.impl;

import carDealerApplication.entity.Administrator;
import carDealerApplication.service.jwtGenerator.AdministratorJwtGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdministratorJwtGeneratorImpl implements AdministratorJwtGenerator {
    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String entityJwtGenerateToken(Administrator administrator) {
        return Jwts.builder().setSubject(administrator.getLogin()).setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
}