package carDealerApplication.service.impl;

import carDealerApplication.api.dto.CarDTO;
import carDealerApplication.dal.CarRepository;
import carDealerApplication.entity.Car;
import carDealerApplication.service.CarService;
import carDealerApplication.service.dtoConverter.CarDTOConverter;
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
        List<Car> carList = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            carList.add(car);
        }
        return carList;
    }

    @Override
    public void deleteEntityById(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public List<Car> fetchAvailableCar() {
        List<Car> carList = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            if (car.isAvailable()) {
                carList.add(car);
            }
        }
        return carList;
    }

    @Override
    public List<Car> fetchUnavailableCar() {
        List<Car> carList = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            if (!car.isAvailable()) {
                carList.add(car);
            }
        }
        return carList;
    }

    @Override
    public List<CarDTO> optimizedFetchAvailableCar() {
        List<CarDTO> carDTOList = new ArrayList<>();
        for (Car car : carRepository.findAll()) {
            if (car.isAvailable()) {
                carDTOList.add(carDTOConverter.convertToDTO(car));
            }
        }
        return carDTOList;
    }
}