package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.LocationDTO;
import carDealerApplication.entity.Location;
import carDealerApplication.service.dtoConverter.LocationDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LocationDTOConverterImpl implements LocationDTOConverter {
    @Override
    public LocationDTO convertToDTO(Location location) {
        return LocationDTO.builder()
                .country(location.getCountry())
                .city(location.getCity())
                .street(location.getStreet())
                .build();
    }
}