package carDealerApplication.dal;

import carDealerApplication.entity.Administrator;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
    Optional<Administrator> getAdministratorByLoginAndPassword(String login, String password);

    Optional<Administrator> getAdministratorByLogin(String login);
}