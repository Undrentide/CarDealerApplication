package carDealerApplication.service.impl;

import carDealerApplication.dal.ConsultantRepository;
import carDealerApplication.entity.Consultant;
import carDealerApplication.service.ConsultantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsultantServiceImpl implements ConsultantService {
    private final ConsultantRepository consultantRepository;

    @Override
    public void upsertEntity(Consultant consultant) {
        consultantRepository.save(consultant);
    }

    @Override
    public List<Consultant> fetchEntityList() {
        List<Consultant> consultantList = new ArrayList<>();
        for (Consultant consultant : consultantRepository.findAll()) {
            consultantList.add(consultant);
        }
        return consultantList;
    }

    @Override
    public void deleteEntityById(Long consultantId) {
        consultantRepository.deleteById(consultantId);
    }
}