package ua.undrentide.cardealer.api.converter.impl;

import ua.undrentide.cardealer.api.dto.LocationDTO;
import ua.undrentide.cardealer.entity.Location;
import ua.undrentide.cardealer.api.converter.EntityDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class LocationDTOConverter implements EntityDTOConverter<Location, LocationDTO> {
    @Override
    public LocationDTO convertToDTO(Location location) {
        return LocationDTO.builder()
                .country(location.getCountry())
                .city(location.getCity())
                .street(location.getStreet())
                .build();
    }

    @Override
    public Location convertToEntity(LocationDTO consultantDTO) {
        return null;
    }

    @Override
    public List<LocationDTO> convertAllToDto(List<Location> entityList) {
        return entityList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}