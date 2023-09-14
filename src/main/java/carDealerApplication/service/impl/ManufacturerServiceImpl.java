package carDealerApplication.service.impl;

import carDealerApplication.dal.ManufacturerRepository;
import carDealerApplication.entity.Manufacturer;
import carDealerApplication.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    @Override
    public void upsertEntity(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public List<Manufacturer> fetchEntityList() {
        List<Manufacturer> manufacturerList = new ArrayList<>();
        for (Manufacturer manufacturer : manufacturerRepository.findAll()) {
            manufacturerList.add(manufacturer);
        }
        return manufacturerList;
    }

    @Override
    public void deleteEntityById(Long manufactureId) {
        manufacturerRepository.deleteById(manufactureId);
    }
}