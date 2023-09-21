package carDealerApplication.service.impl;

import carDealerApplication.dal.ManufacturerRepository;
import carDealerApplication.entity.Manufacturer;
import carDealerApplication.exception.EntityNotFoundException;
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
        return new ArrayList<>(manufacturerRepository.findAll());
    }

    @Override
    public void deleteEntityById(Long manufactureId) {
        if (manufacturerRepository.existsById(manufactureId)) {
            manufacturerRepository.deleteById(manufactureId);
        } else {
            throw new EntityNotFoundException("Manufacturer not found.");
        }
    }
}