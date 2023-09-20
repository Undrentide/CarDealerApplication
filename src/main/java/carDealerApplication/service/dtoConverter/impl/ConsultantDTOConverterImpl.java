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