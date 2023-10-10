package ua.undrentide.cardealer.service.impl;

import ua.undrentide.cardealer.dal.ManufacturerRepository;
import ua.undrentide.cardealer.entity.Manufacturer;
import ua.undrentide.cardealer.exception.EntityNotFoundException;
import ua.undrentide.cardealer.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
    public List<Manufacturer> fetchEntityList(PageRequest pageRequest) {
        return new ArrayList<>(manufacturerRepository.findAll(pageRequest).getContent());
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