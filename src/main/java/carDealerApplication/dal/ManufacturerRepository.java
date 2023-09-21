package carDealerApplication.dal;

import carDealerApplication.entity.Manufacturer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
    List<Manufacturer> findAll();
}