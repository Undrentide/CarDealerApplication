package ua.undrentide.cardealer.service.impl;

import ua.undrentide.cardealer.api.dto.DealerCenterDTO;
import ua.undrentide.cardealer.dal.DealerCenterRepository;
import ua.undrentide.cardealer.entity.DealerCenter;
import ua.undrentide.cardealer.exception.EntityNotFoundException;
import ua.undrentide.cardealer.service.DealerCenterService;
import ua.undrentide.cardealer.api.converter.impl.DealerCenterDTOConverter;
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
        }
        if (dealerCenterDTOList.isEmpty()) {
            throw new EntityNotFoundException("All dealer centers for this country are closed or not presented");
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
        }
        if (dealerCenterDTOList.isEmpty()) {
            throw new EntityNotFoundException("All dealer centers for this city are closed or not presented");
        }
        return dealerCenterDTOList;
    }

    @Override
    public List<DealerCenter> fetchAllDealersByCountry(String country, PageRequest pageRequest) {
        List<DealerCenter> dealerCenterList = new ArrayList<>(dealerCenterRepository.findDealerCentersByLocationCountry(country, pageRequest));
        if (dealerCenterList.isEmpty()) {
            throw new EntityNotFoundException("All dealers for this country are not presented");
        }
        return dealerCenterList;
    }

    @Override
    public List<DealerCenter> fetchAllDealersByCity(String city, PageRequest pageRequest) {
        List<DealerCenter> dealerCenterList = new ArrayList<>(dealerCenterRepository.findDealerCentersByLocationCity(city, pageRequest));
        if (dealerCenterList.isEmpty()) {
            throw new EntityNotFoundException("All dealers for this city are not presented");
        }
        return dealerCenterList;
    }
}