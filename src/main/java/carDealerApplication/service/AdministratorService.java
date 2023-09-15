package carDealerApplication.service;

import carDealerApplication.api.dto.AdministratorDTO;

public interface AdministratorService extends EntityService<AdministratorDTO, Long> {
    AdministratorDTO authenticate(AdministratorDTO administratorDTO);
}