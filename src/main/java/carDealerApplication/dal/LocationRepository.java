package carDealerApplication.dal;

import carDealerApplication.entity.Location;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {
    List<Location> getLocationsByCountry(String country);
}