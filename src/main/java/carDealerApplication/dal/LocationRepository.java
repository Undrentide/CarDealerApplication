package carDealerApplication.dal;

import carDealerApplication.entity.Location;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> getLocationsByCountry(String country, PageRequest pageRequest);

    List<Location> findAll();
}