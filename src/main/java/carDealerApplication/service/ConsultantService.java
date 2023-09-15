package carDealerApplication.service;

import carDealerApplication.api.dto.ConsultantDTO;

public interface ConsultantService extends EntityService<ConsultantDTO, Long> {
    ConsultantDTO authenticate(ConsultantDTO consultantDTO);
}