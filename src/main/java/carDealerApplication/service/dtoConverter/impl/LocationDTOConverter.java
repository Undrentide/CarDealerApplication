package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.LocationDTO;
import carDealerApplication.entity.Location;
import carDealerApplication.service.dtoConverter.EntityDTOConverter;
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

    @Override
    public List<Location> convertAllToEntity(List<LocationDTO> locationDTOS) {
        return null;
    }
}