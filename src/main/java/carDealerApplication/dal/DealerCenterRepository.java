package carDealerApplication.dal;

import carDealerApplication.entity.DealerCenter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealerCenterRepository extends JpaRepository<DealerCenter, Long> {
    List<DealerCenter> findDealerCentersByLocationCountry(String country);

    List<DealerCenter> findDealerCentersByLocationCity(String city);

    List<DealerCenter> findDealerCentersByLocationCountry(String country, PageRequest pageRequest);

    List<DealerCenter> findDealerCentersByLocationCity(String city, PageRequest pageRequest);

    List<DealerCenter> findAll();
}