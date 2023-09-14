package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.service.dtoConverter.DealerCenterDTOConverter;
import carDealerApplication.service.dtoConverter.LocationDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DealerCenterDTOConverterImpl implements DealerCenterDTOConverter {
    private final LocationDTOConverter locationDTOConverter;

    @Override
    public DealerCenterDTO convertToDTO(DealerCenter dealerCenter) {
        DealerCenterDTO dealerCenterDTO = new DealerCenterDTO();
        dealerCenterDTO.locationDTO = locationDTOConverter.convertToDTO(dealerCenter.getLocation());
        dealerCenterDTO.hours = dealerCenter.getHours();
        return dealerCenterDTO;
    }
}