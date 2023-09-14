package carDealerApplication.dal;

import carDealerApplication.entity.DealerCenter;
import org.springframework.data.repository.CrudRepository;

public interface DealerCenterRepository extends CrudRepository<DealerCenter, Long> {
}