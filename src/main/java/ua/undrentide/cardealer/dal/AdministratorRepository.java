package ua.undrentide.cardealer.dal;

import ua.undrentide.cardealer.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Optional<Administrator> getAdministratorByLoginAndPassword(String login, String password);

    Optional<Administrator> getAdministratorByLogin(String login);

    Optional<Administrator> getAdministratorByPhone(Long phone);

    List<Administrator> findAll();
}