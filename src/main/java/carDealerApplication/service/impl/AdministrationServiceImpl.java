package carDealerApplication.service.impl;

import carDealerApplication.api.dto.AdministratorDTO;
import carDealerApplication.dal.AdministratorRepository;
import carDealerApplication.entity.Administrator;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.exception.UserNotFoundException;
import carDealerApplication.service.AdministratorService;
import carDealerApplication.service.dtoConverter.AdministratorDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministrationServiceImpl implements AdministratorService {
    private final AdministratorRepository administratorRepository;
    private final AdministratorDTOConverter administratorDTOConverter;

    @Override
    public void upsertEntity(AdministratorDTO administratorDTO) {
        administratorRepository.save(administratorDTOConverter.convertToEntity(administratorDTO));
    }

    @Override
    public List<AdministratorDTO> fetchEntityList() {
        List<AdministratorDTO> administratorDTOList = new ArrayList<>();
        for (Administrator administrator : administratorRepository.findAll()) {
            administratorDTOList.add(administratorDTOConverter.convertToDTO(administrator));
        }
        return administratorDTOList;
    }

    @Override
    public void deleteEntityById(Long administratorId) {
        if (administratorRepository.existsById(administratorId)) {
            administratorRepository.deleteById(administratorId);
        } else {
            throw new EntityNotFoundException("User not found.");
        }

    }

    @Override
    public AdministratorDTO authenticate(AdministratorDTO administratorDTO) {
        return administratorDTOConverter.convertToDTO(administratorRepository
                .getAdministratorByLoginAndPassword(administratorDTO.login, administratorDTO.password)
                .orElseThrow(() -> new UserNotFoundException("Wrong credentials.")));
    }
}