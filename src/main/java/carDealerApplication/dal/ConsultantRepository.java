package carDealerApplication.dal;

import carDealerApplication.entity.Consultant;
import org.springframework.data.repository.CrudRepository;

public interface ConsultantRepository extends CrudRepository<Consultant, Long> {
}