package ua.undrentide.cardealer.service.impl;

import ua.undrentide.cardealer.dal.LocationRepository;
import ua.undrentide.cardealer.entity.Location;
import ua.undrentide.cardealer.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public void upsertEntity(Location location) {
        throw new UnsupportedOperationException("I forbid u to upsert locations.");
    }

    @Override
    public List<Location> fetchEntityList(PageRequest pageRequest) {
        return locationRepository.findAll(pageRequest).getContent();
    }

    @Override
    public void deleteEntityById(Long locationId) {
        throw new UnsupportedOperationException("I forbid u to delete locations.");
    }
}