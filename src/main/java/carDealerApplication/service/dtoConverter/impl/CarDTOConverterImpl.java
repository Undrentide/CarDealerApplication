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
        return CarDTO.builder()
                .engine(car.getEngine())
                .color(car.getColor())
                .brand(car.getBrand())
                .country(car.getCountry())
                .price(car.getPrice())
                .build();
    }
}