package ua.undrentide.cardealer.service.impl;

import ua.undrentide.cardealer.api.dto.AdministratorDTO;
import ua.undrentide.cardealer.dal.AdministratorRepository;
import ua.undrentide.cardealer.exception.EntityNotFoundException;
import ua.undrentide.cardealer.exception.UserNotFoundException;
import ua.undrentide.cardealer.service.AdministratorService;
import ua.undrentide.cardealer.api.converter.impl.AdministratorDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    public List<AdministratorDTO> fetchEntityList(PageRequest pageRequest) {
        return administratorDTOConverter.convertAllToDto(administratorRepository
                .findAll(pageRequest).getContent());
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