package carDealerApplication.service.dtoConverter;

import carDealerApplication.api.dto.ConsultantDTO;
import carDealerApplication.entity.Consultant;

public interface ConsultantDTOConverter extends EntityDTOConverter<Consultant, ConsultantDTO> {
    Consultant convertToEntity (ConsultantDTO consultantDTO);
}