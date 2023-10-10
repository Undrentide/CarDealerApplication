package ua.undrentide.cardealer.service;

import ua.undrentide.cardealer.api.dto.CarDTO;
import ua.undrentide.cardealer.entity.Car;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface CarService extends EntityService<Car, Long> {
    List<Car> fetchAvailableCars(PageRequest pageRequest);

    List<Car> fetchUnavailableCars(PageRequest pageRequest);

    List<CarDTO> limitedFetchAvailableCars(PageRequest pageRequest);
}