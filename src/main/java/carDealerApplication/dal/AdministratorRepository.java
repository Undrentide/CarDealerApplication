package carDealerApplication.dal;

import carDealerApplication.entity.Administrator;
import org.springframework.data.repository.CrudRepository;

public interface AdministratorRepository extends CrudRepository<Administrator, Long> {
}