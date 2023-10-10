package ua.undrentide.cardealer.api.converter.impl;

import ua.undrentide.cardealer.api.dto.DealerCenterDTO;
import ua.undrentide.cardealer.entity.DealerCenter;
import ua.undrentide.cardealer.api.converter.EntityDTOConverter;
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
                .openHours(dealerCenter.getOpenHours())
                .closeHours(dealerCenter.getCloseHours())
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
}