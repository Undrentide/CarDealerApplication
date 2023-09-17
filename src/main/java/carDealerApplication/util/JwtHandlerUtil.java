package carDealerApplication.util;

import carDealerApplication.exception.InvalidJwtException;
import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class JwtHandlerUtil {
    @Value("${jwt.secret}")
    private String secret;

    public void validateJwt(String jwtToken) {
        String cleanedUpJwtToken = jwtToken.substring(7);
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(cleanedUpJwtToken);
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e) {
            throw new InvalidJwtException(e.getMessage());
        }
    }
}