package carDealerApplication.dal;

import carDealerApplication.entity.DealerCenter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealerCenterRepository extends JpaRepository<DealerCenter, Long> {
    List<DealerCenter> findDealerCentersByLocationCountryAndIsOpen(String country, Boolean isOpen, PageRequest pageRequest);

    List<DealerCenter> findDealerCentersByLocationCityAndIsOpen(String city, Boolean isOpen, PageRequest pageRequest);

    List<DealerCenter> findDealerCentersByLocationCountry(String country, PageRequest pageRequest);

    List<DealerCenter> findDealerCentersByLocationCity(String city, PageRequest pageRequest);

    List<DealerCenter> findAll();
}