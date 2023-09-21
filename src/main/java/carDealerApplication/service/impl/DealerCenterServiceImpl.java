package carDealerApplication.service.impl;

import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.dal.DealerCenterRepository;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.service.DealerCenterService;
import carDealerApplication.service.dtoConverter.impl.DealerCenterDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
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
    public List<DealerCenter> fetchEntityList(PageRequest pageRequest) {
        return new ArrayList<>(dealerCenterRepository.findAll(pageRequest).getContent());
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
    public List<DealerCenterDTO> fetchOpenedDealersByCountry(String country, PageRequest pageRequest) {
        return new ArrayList<>(dealerCenterDTOConverter.convertAllToDto(dealerCenterRepository
                .findDealerCentersByLocationCountryAndIsOpen(country, true, pageRequest)));
    }

    @Override
    public List<DealerCenterDTO> fetchOpenedDealersByCity(String city, PageRequest pageRequest) {
        return new ArrayList<>(dealerCenterDTOConverter.convertAllToDto(dealerCenterRepository
                .findDealerCentersByLocationCityAndIsOpen(city, true, pageRequest)));
    }

    @Override
    public List<DealerCenter> fetchAllDealersByCountry(String country, PageRequest pageRequest) {
        return new ArrayList<>(dealerCenterRepository.findDealerCentersByLocationCountry(country, pageRequest));
    }

    @Override
    public List<DealerCenter> fetchAllDealersByCity(String city, PageRequest pageRequest) {
        return new ArrayList<>(dealerCenterRepository.findDealerCentersByLocationCity(city, pageRequest));
    }
}