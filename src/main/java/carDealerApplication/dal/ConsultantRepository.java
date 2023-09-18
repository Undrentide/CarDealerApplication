package carDealerApplication.dal;

import carDealerApplication.entity.Consultant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConsultantRepository extends CrudRepository<Consultant, Long> {
    Optional<Consultant> getConsultantByLoginAndPassword(String login, String password);

    Optional<Consultant> getConsultantByLogin(String login);
}