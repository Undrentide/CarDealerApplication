package carDealerApplication.service.impl;

import carDealerApplication.dal.LocationRepository;
import carDealerApplication.entity.Location;
import carDealerApplication.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public void upsertEntity(Location location) {
        System.out.println("I forbid u to upsert new locations.");
    }

    @Override
    public List<Location> fetchEntityList(PageRequest pageRequest) {
        return new ArrayList<>(locationRepository.findAll(pageRequest).getContent());
    }

    @Override
    public void deleteEntityById(Long locationId) {
        System.out.println("I forbid u to delete locations.");
    }
}