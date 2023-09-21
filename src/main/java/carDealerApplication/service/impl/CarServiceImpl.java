package carDealerApplication.service.impl;

import carDealerApplication.api.dto.CarDTO;
import carDealerApplication.dal.CarRepository;
import carDealerApplication.entity.Car;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.service.CarService;
import carDealerApplication.service.dtoConverter.impl.CarDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
    public List<Car> fetchEntityList(PageRequest pageRequest) {
        return carRepository.findAll(pageRequest).getContent();
    }

    @Override
    public void deleteEntityById(Long carId) {
        if (carRepository.existsById(carId)) {
            carRepository.deleteById(carId);
        } else {
            throw new EntityNotFoundException("Car not found.");
        }
    }

    @Override
    public List<Car> fetchAvailableCars(PageRequest pageRequest) {
        return new ArrayList<>(carRepository.findCarsByIsAvailable(true, pageRequest));
    }

    @Override
    public List<Car> fetchUnavailableCars(PageRequest pageRequest) {
        return new ArrayList<>(carRepository.findCarsByIsAvailable(false, pageRequest));
    }

    @Override
    public List<CarDTO> limitedFetchAvailableCars(PageRequest pageRequest) {
        return new ArrayList<>(carDTOConverter.convertAllToDto(carRepository.findCarsByIsAvailable(true, pageRequest)));
    }
}