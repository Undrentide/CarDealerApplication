package carDealerApplication.service.impl;

import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.dal.DealerCenterRepository;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.service.DealerCenterService;
import carDealerApplication.service.dtoConverter.impl.DealerCenterDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DealerCenterServiceImpl implements DealerCenterService {
    private final DealerCenterRepository dealerCenterRepository;
    private final DealerCenterDTOConverter dealerCenterDTOConverter;

    @Override
    public void upsertEntity(DealerCenter dealerCenter) {
        dealerCenterRepository.save(dealerCenter);
    }

    @Override
    public List<DealerCenter> fetchEntityList() {
        return new ArrayList<>(dealerCenterRepository.findAll());
    }

    @Override
    public void deleteEntityById(Long dealerCenterId) {
        if (dealerCenterRepository.existsById(dealerCenterId)) {
            dealerCenterRepository.deleteById(dealerCenterId);
        } else {
            throw new EntityNotFoundException("Dealer center not found.");
        }
    }

    @Override
    public List<DealerCenterDTO> fetchOpenedDealersByCountry(String country) {
        return new ArrayList<>(dealerCenterDTOConverter.convertAllToDto(dealerCenterRepository
                .findDealerCentersByLocationCountryAndIsOpen(country, true)));
    }

    @Override
    public List<DealerCenterDTO> fetchOpenedDealersByCity(String city) {
        return new ArrayList<>(dealerCenterDTOConverter.convertAllToDto(dealerCenterRepository
                .findDealerCentersByLocationCityAndIsOpen(city, true)));
    }

    @Override
    public List<DealerCenter> fetchAllDealersByCountry(String country) {
        return new ArrayList<>(dealerCenterRepository.findDealerCentersByLocationCountry(country));
    }

    @Override
    public List<DealerCenter> fetchAllDealersByCity(String city) {
        return new ArrayList<>(dealerCenterRepository.findDealerCentersByLocationCity(city));
    }
}