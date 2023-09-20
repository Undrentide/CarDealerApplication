package carDealerApplication.service.impl;

import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.dal.DealerCenterRepository;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.service.DealerCenterService;
import carDealerApplication.service.dtoConverter.DealerCenterDTOConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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
        return new ArrayList<>((Collection<? extends DealerCenter>) dealerCenterRepository.findAll());
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
        List<DealerCenterDTO> dealerCenterDTOList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findDealerCentersByLocationCountryAndIsOpen(country, true)) {
            dealerCenterDTOList.add(dealerCenterDTOConverter.convertToDTO(dealerCenter));
        }
        return dealerCenterDTOList;
    }

    @Override
    public List<DealerCenterDTO> fetchOpenedDealersByCity(String city) {
        List<DealerCenterDTO> dealerCenterDTOList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findDealerCentersByLocationCityAndIsOpen(city, true)) {
            dealerCenterDTOList.add(dealerCenterDTOConverter.convertToDTO(dealerCenter));
        }
        return dealerCenterDTOList;
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