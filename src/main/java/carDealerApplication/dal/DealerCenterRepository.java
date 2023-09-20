package carDealerApplication.dal;

import carDealerApplication.entity.DealerCenter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DealerCenterRepository extends CrudRepository<DealerCenter, Long> {
    List<DealerCenter> findDealerCentersByLocationCountryAndIsOpen(String country, Boolean isOpen);

    List<DealerCenter> findDealerCentersByLocationCityAndIsOpen(String city, Boolean isOpen);

    List<DealerCenter> findDealerCentersByLocationCountry(String country);

    List<DealerCenter> findDealerCentersByLocationCity(String city);
}