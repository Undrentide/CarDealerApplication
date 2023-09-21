package carDealerApplication.service.impl;

import carDealerApplication.api.dto.ConsultantDTO;
import carDealerApplication.dal.ConsultantRepository;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.exception.UserNotFoundException;
import carDealerApplication.service.ConsultantService;
import carDealerApplication.service.dtoConverter.impl.ConsultantDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultantServiceImpl implements ConsultantService {
    private final ConsultantRepository consultantRepository;
    private final ConsultantDTOConverter consultantDTOConverter;

    @Override
    public void upsertEntity(ConsultantDTO consultantDTO) {
        consultantRepository.save(consultantDTOConverter.convertToEntity(consultantDTO));
    }

    @Override
    public List<ConsultantDTO> fetchEntityList(PageRequest pageRequest) {
        return new ArrayList<>(consultantDTOConverter.convertAllToDto(consultantRepository.findAll(pageRequest).getContent()));
    }

    @Override
    public void deleteEntityById(Long consultantId) {
        if (consultantRepository.existsById(consultantId)) {
            consultantRepository.deleteById(consultantId);
        } else {
            throw new EntityNotFoundException("User not found.");
        }
    }

    @Override
    public ConsultantDTO authenticate(ConsultantDTO consultantDTO) {
        return consultantDTOConverter.convertToDTO(consultantRepository
                .getConsultantByLoginAndPassword(consultantDTO.login, consultantDTO.password)
                .orElseThrow(() -> new UserNotFoundException("Wrong credentials.")));
    }
}