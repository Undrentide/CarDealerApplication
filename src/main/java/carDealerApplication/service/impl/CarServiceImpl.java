package carDealerApplication.service.impl;

import carDealerApplication.api.dto.CarDTO;
import carDealerApplication.dal.CarRepository;
import carDealerApplication.entity.Car;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.service.CarService;
import carDealerApplication.service.dtoConverter.impl.CarDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarDTOConverter carDTOConverter;

    @Override
    public void upsertEntity(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> fetchEntityList() {
        return new ArrayList<>(carRepository.findAll());
    }

    @Override
    public void deleteEntityById(Long carId) {
        if(carRepository.existsById(carId)){
            carRepository.deleteById(carId);
        } else {
            throw new EntityNotFoundException("Car not found.");
        }
    }

    @Override
    public List<Car> fetchAvailableCar() {
        return new ArrayList<>(carRepository.findCarsByIsAvailable(true));
    }

    @Override
    public List<Car> fetchUnavailableCar() {
        return new ArrayList<>(carRepository.findCarsByIsAvailable(false));
    }

    @Override
    public List<CarDTO> limitedFetchAvailableCar() {
        return new ArrayList<>(carDTOConverter.convertAllToDto(carRepository.findCarsByIsAvailable(true)));
    }
}