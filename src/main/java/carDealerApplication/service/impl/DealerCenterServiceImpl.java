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

import java.time.LocalTime;
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
        List<DealerCenterDTO> dealerCenterDTOList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findDealerCentersByLocationCountry(country)) {
            if (dealerCenter.getOpenHours().isAfter(LocalTime.now()) && dealerCenter.getCloseHours().isBefore(LocalTime.now())) {
                dealerCenterDTOList.add(dealerCenterDTOConverter.convertToDTO(dealerCenter));
            }
            if (dealerCenterDTOList.isEmpty()) {
                throw new EntityNotFoundException("All dealer centers for this country is closed");
            }
        }
        if (dealerCenterDTOList.isEmpty()) {
            throw new EntityNotFoundException("No dealer centers found for this country");
        }
        return dealerCenterDTOList;
    }

    @Override
    public List<DealerCenterDTO> fetchOpenedDealersByCity(String city, PageRequest pageRequest) {
        List<DealerCenterDTO> dealerCenterDTOList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findDealerCentersByLocationCity(city)) {
            if (dealerCenter.getOpenHours().isAfter(LocalTime.now()) && dealerCenter.getCloseHours().isBefore(LocalTime.now())) {
                dealerCenterDTOList.add(dealerCenterDTOConverter.convertToDTO(dealerCenter));
            }
            if (dealerCenterDTOList.isEmpty()) {
                throw new EntityNotFoundException("All dealer centers for this city is closed");
            }
        }
        if (dealerCenterDTOList.isEmpty()) {
            throw new EntityNotFoundException("No dealer centers found for this city");
        }
        return null;
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