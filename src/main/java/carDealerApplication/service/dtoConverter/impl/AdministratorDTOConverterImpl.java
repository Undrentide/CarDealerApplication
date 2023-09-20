package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.AdministratorDTO;
import carDealerApplication.entity.Administrator;
import carDealerApplication.service.dtoConverter.AdministratorDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AdministratorDTOConverterImpl implements AdministratorDTOConverter {
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
        Administrator administrator = new Administrator();
        administrator.setId(administratorDTO.id);
        administrator.setFirstName(administratorDTO.firstName);
        administrator.setLastName(administratorDTO.lastName);
        administrator.setPhone(administratorDTO.phone);
        administrator.setLogin(administratorDTO.login);
        administrator.setPassword(administratorDTO.password);
        administrator.setDealerCenterList(administratorDTO.dealerCenterList);
        return administrator;
    }
}