package carDealerApplication.dal;

import carDealerApplication.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findCarsByIsAvailable(Boolean isAvailable);
}