package carDealerApplication.service.dtoConverter;

import carDealerApplication.api.dto.AdministratorDTO;
import carDealerApplication.entity.Administrator;

public interface AdministratorDTOConverter extends EntityDTOConverter<Administrator, AdministratorDTO> {
    Administrator convertToEntity(AdministratorDTO administratorDTO);
}