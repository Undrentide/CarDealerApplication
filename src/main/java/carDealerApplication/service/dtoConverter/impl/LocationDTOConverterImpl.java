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
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.country = location.getCountry();
        locationDTO.city = location.getCity();
        locationDTO.street = location.getStreet();
        return locationDTO;
    }
}