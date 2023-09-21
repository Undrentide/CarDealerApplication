package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.AdministratorDTO;
import carDealerApplication.entity.Administrator;
import carDealerApplication.service.dtoConverter.EntityDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
public class AdministratorDTOConverter implements EntityDTOConverter<Administrator, AdministratorDTO> {
    @Override
    public AdministratorDTO convertToDTO(Administrator administrator) {
        return AdministratorDTO.builder()
                .id(administrator.getId())
                .firstName(administrator.getFirstName())
                .lastName(administrator.getLastName())
                .phone(administrator.getPhone())
                .login(administrator.getLogin())
                .password(administrator.getPassword())
                .dealerCenterList(administrator.getDealerCenterList())
                .build();
    }

    @Override
    public Administrator convertToEntity(AdministratorDTO administratorDTO) {
        return Administrator.builder()
                .id(administratorDTO.id)
                .firstName(administratorDTO.firstName)
                .lastName(administratorDTO.lastName)
                .phone(administratorDTO.phone)
                .login(administratorDTO.login)
                .password(administratorDTO.password)
                .dealerCenterList(administratorDTO.dealerCenterList)
                .build();
    }

    @Override
    public List<AdministratorDTO> convertAllToDto(List<Administrator> entityList) {
        return entityList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<Administrator> convertAllToEntity(List<AdministratorDTO> dtoList) {
        return dtoList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }
}