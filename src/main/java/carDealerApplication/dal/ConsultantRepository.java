package carDealerApplication.dal;

import carDealerApplication.entity.Consultant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultantRepository extends CrudRepository<Consultant, Long> {
    Optional<Consultant> getConsultantByLoginAndPassword(String login, String password);

    Optional<Consultant> getConsultantByLogin(String login);

    Optional<Consultant> getConsultantByPhone(Long phone);

    List<Consultant> findAll();
}