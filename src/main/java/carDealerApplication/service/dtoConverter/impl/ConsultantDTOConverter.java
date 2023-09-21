package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.ConsultantDTO;
import carDealerApplication.entity.Consultant;
import carDealerApplication.service.dtoConverter.EntityDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class ConsultantDTOConverter implements EntityDTOConverter<Consultant, ConsultantDTO> {
    @Override
    public ConsultantDTO convertToDTO(Consultant consultant) {
        return ConsultantDTO.builder()
                .id(consultant.getId())
                .firstName(consultant.getFirstName())
                .lastName(consultant.getLastName())
                .phone(consultant.getPhone())
                .login(consultant.getLogin())
                .password(consultant.getPassword())
                .rate(consultant.getRate())
                .manufacturer(consultant.getManufacturer())
                .build();
    }

    @Override
    public Consultant convertToEntity(ConsultantDTO consultantDTO) {
        return Consultant.builder()
                .id(consultantDTO.id)
                .firstName(consultantDTO.firstName)
                .lastName(consultantDTO.lastName)
                .phone(consultantDTO.phone)
                .login(consultantDTO.login)
                .password(consultantDTO.password)
                .rate(consultantDTO.rate)
                .manufacturer(consultantDTO.manufacturer)
                .build();
    }

    @Override
    public List<ConsultantDTO> convertAllToDto(List<Consultant> entityList) {
        return entityList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Consultant> convertAllToEntity(List<ConsultantDTO> dtoList) {
        return dtoList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }
}