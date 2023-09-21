package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.service.dtoConverter.EntityDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class DealerCenterDTOConverter implements EntityDTOConverter<DealerCenter, DealerCenterDTO> {
    private final LocationDTOConverter locationDTOConverter;

    @Override
    public DealerCenterDTO convertToDTO(DealerCenter dealerCenter) {
        return DealerCenterDTO.builder()
                .locationDTO(locationDTOConverter.convertToDTO(dealerCenter.getLocation()))
                .hours(dealerCenter.getHours())
                .build();
    }

    @Override
    public DealerCenter convertToEntity(DealerCenterDTO consultantDTO) {
        return null;
    }

    @Override
    public List<DealerCenterDTO> convertAllToDto(List<DealerCenter> entityList) {
        return entityList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DealerCenter> convertAllToEntity(List<DealerCenterDTO> dealerCenterDTOS) {
        return null;
    }
}