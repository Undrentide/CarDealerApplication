package carDealerApplication.service.impl;

import carDealerApplication.dal.AdministratorRepository;
import carDealerApplication.entity.Administrator;
import carDealerApplication.service.AdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdministrationServiceImpl implements AdministratorService {
    private final AdministratorRepository administratorRepository;

    @Override
    public void upsertEntity(Administrator administrator) {
        administratorRepository.save(administrator);
    }

    @Override
    public List<Administrator> fetchEntityList() {
        List<Administrator> administratorList = new ArrayList<>();
        for (Administrator administrator : administratorRepository.findAll()) {
            administratorList.add(administrator);
        }
        return administratorList;
    }

    @Override
    public void deleteEntityById(Long administratorId) {
        administratorRepository.deleteById(administratorId);
    }
}