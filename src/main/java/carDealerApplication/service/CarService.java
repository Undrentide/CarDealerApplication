package carDealerApplication.service;

import carDealerApplication.api.dto.CarDTO;
import carDealerApplication.entity.Car;

import java.util.List;

public interface CarService extends EntityService<Car, Long> {
    List<Car> fetchAvailableCar();

    List<Car> fetchUnavailableCar();

    List<CarDTO> limitedFetchAvailableCar();
}