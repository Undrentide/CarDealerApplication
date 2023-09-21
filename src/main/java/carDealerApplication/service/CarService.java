package carDealerApplication.service;

import carDealerApplication.api.dto.CarDTO;
import carDealerApplication.entity.Car;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CarService extends EntityService<Car, Long> {
    List<Car> fetchAvailableCar(PageRequest pageRequest);

    List<Car> fetchUnavailableCar(PageRequest pageRequest);

    List<CarDTO> limitedFetchAvailableCar(PageRequest pageRequest);
}