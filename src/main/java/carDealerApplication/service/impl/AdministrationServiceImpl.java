package carDealerApplication.service.impl;

import carDealerApplication.dal.AdministratorRepository;
import carDealerApplication.entity.Administrator;
import carDealerApplication.exception.UserNotFoundException;
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

    @Override
    public Administrator getAdministratorLoginAndPassword(String login, String password) throws UserNotFoundException {
        Administrator administratorHolder = new Administrator();
        for (Administrator administrator : administratorRepository.findAll()) {
            if (login.equals(administrator.getLogin()) && password.equals(administrator.getPassword())) {
                administratorHolder = administrator;
            }
        }
        return administratorHolder;
    }
}