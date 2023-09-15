package carDealerApplication.service.dtoConverter.impl;

import carDealerApplication.api.dto.ConsultantDTO;
import carDealerApplication.entity.Consultant;
import carDealerApplication.service.dtoConverter.ConsultantDTOConverter;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConsultantDTOConverterImpl implements ConsultantDTOConverter {
    @Override
    public ConsultantDTO convertToDTO(Consultant consultant) {
        ConsultantDTO consultantDTO = new ConsultantDTO();
        consultantDTO.id = consultant.getId();
        consultantDTO.firstName = consultant.getFirstName();
        consultantDTO.lastName = consultant.getLastName();
        consultantDTO.phone = consultant.getPhone();
        consultantDTO.login = consultant.getLogin();
        consultantDTO.password = consultant.getPassword();
        consultantDTO.rate = consultant.getRate();
        consultantDTO.manufacturer = consultant.getManufacturer();
        return consultantDTO;
    }

    @Override
    public Consultant convertToEntity(ConsultantDTO consultantDTO) {
        Consultant consultant = new Consultant();
        consultant.setId(consultantDTO.id);
        consultant.setFirstName(consultantDTO.firstName);
        consultant.setLastName(consultantDTO.lastName);
        consultant.setPhone(consultantDTO.phone);
        consultant.setLogin(consultantDTO.login);
        consultant.setPassword(consultantDTO.password);
        consultant.setRate(consultantDTO.rate);
        consultant.setManufacturer(consultantDTO.manufacturer);
        return consultant;
    }
}