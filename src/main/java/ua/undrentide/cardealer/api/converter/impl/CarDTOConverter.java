package ua.undrentide.cardealer.api.converter.impl;

import ua.undrentide.cardealer.api.dto.CarDTO;
import ua.undrentide.cardealer.entity.Car;
import ua.undrentide.cardealer.api.converter.EntityDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class CarDTOConverter implements EntityDTOConverter<Car, CarDTO> {
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

    @Override
    public Car convertToEntity(CarDTO consultantDTO) {
        return null;
    }

    @Override
    public List<CarDTO> convertAllToDto(List<Car> entityList) {
        return entityList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}