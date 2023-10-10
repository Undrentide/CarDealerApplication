package ua.undrentide.cardealer.util;

import ua.undrentide.cardealer.dal.AdministratorRepository;
import ua.undrentide.cardealer.dal.ConsultantRepository;
import ua.undrentide.cardealer.exception.InvalidJwtException;
import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtHandlerUtil {

    @Value("${jwt.secret}")
    private String secret;
    private final ConsultantRepository consultantRepository;
    private final AdministratorRepository administratorRepository;

    public void validateJwtForConsultant(String jwtToken) {
        if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
            if (!consultantRepository.getConsultantByLogin(Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(jwtToken.substring(7)).getBody().getSubject()).isPresent()) {
                throw new InvalidJwtException("Access denied.");
            }
        } else {
            throw new InvalidJwtException("JWT token does not begin with Bearer string");
        }
    }

    public void validateJwtForAdministrator(String jwtToken) {
        if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
            if (!administratorRepository.getAdministratorByLogin(Jwts.parser().setSigningKey(secret)
                    .parseClaimsJws(jwtToken.substring(7)).getBody().getSubject()).isPresent()) {
                throw new InvalidJwtException("Access denied.");
            }
        } else {
            throw new InvalidJwtException("JWT token does not begin with Bearer string");
        }
    }
}