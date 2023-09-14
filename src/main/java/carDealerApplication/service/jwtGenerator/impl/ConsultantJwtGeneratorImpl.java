package carDealerApplication.service.jwtGenerator.impl;

import carDealerApplication.entity.Consultant;
import carDealerApplication.service.jwtGenerator.ConsultantJwtGenerator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ConsultantJwtGeneratorImpl implements ConsultantJwtGenerator {
    @Value("${jwt.secret}")
    private String secret;

    @Override
    public String entityJwtGenerateToken(Consultant consultant) {
        return Jwts.builder().setSubject(consultant.getLogin()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, secret).compact();
    }
}