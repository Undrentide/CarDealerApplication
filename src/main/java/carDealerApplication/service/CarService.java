package carDealerApplication.service;

import carDealerApplication.api.dto.CarDTO;
import carDealerApplication.entity.Car;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CarService extends EntityService<Car, Long> {
    List<Car> fetchAvailableCars(PageRequest pageRequest);

    List<Car> fetchUnavailableCars(PageRequest pageRequest);

    List<CarDTO> limitedFetchAvailableCars(PageRequest pageRequest);
}