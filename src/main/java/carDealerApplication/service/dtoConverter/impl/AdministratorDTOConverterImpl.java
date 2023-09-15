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
        AdministratorDTO administratorDTO = new AdministratorDTO();
        administratorDTO.id = administrator.getId();
        administratorDTO.firstName = administrator.getFirstName();
        administratorDTO.lastName = administrator.getLastName();
        administratorDTO.phone = administrator.getPhone();
        administratorDTO.login = administrator.getLogin();
        administratorDTO.password = administrator.getPassword();
        administratorDTO.dealerCenterList = administrator.getDealerCenterList();
        return administratorDTO;
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
