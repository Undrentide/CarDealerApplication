package carDealerApplication.service.jwtGenerator;

public interface EntityJwtGenerator<T> {
    String entityJwtGenerateToken(T user);
}