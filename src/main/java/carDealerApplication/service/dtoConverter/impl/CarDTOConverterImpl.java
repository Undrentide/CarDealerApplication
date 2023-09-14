package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.CarDTO;
import carDealerApplication.entity.Car;
import carDealerApplication.service.dtoConverter.CarDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CarDTOConverterImpl implements CarDTOConverter {
    @Override
    public CarDTO convertToDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.engine = car.getEngine();
        carDTO.color = car.getColor();
        carDTO.brand = car.getBrand();
        carDTO.country = car.getCountry();
        carDTO.price = car.getPrice();
        return carDTO;
    }
}