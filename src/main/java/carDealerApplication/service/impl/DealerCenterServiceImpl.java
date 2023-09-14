package carDealerApplication.service.impl;

import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.dal.DealerCenterRepository;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.service.DealerCenterService;
import carDealerApplication.service.dtoConverter.DealerCenterDTOConverter;
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
        List<DealerCenter> dealerCenterList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findAll()) {
            dealerCenterList.add(dealerCenter);
        }
        return dealerCenterList;
    }

    @Override
    public void deleteEntityById(Long dealerCenterId) {
        dealerCenterRepository.deleteById(dealerCenterId);
    }

    @Override
    public List<DealerCenterDTO> fetchOpenedDealersByCountry(String country) {
        List<DealerCenterDTO> dealerCenterDTOList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findAll()) {
            if (country.equals(dealerCenter.getLocation().getCountry()) && dealerCenter.isOpen()) {
                dealerCenterDTOList.add(dealerCenterDTOConverter.convertToDTO(dealerCenter));
            }
        }
        return dealerCenterDTOList;
    }

    @Override
    public List<DealerCenterDTO> fetchOpenedDealersByCity(String city) {
        List<DealerCenterDTO> dealerCenterDTOList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findAll()) {
            if (city.equals(dealerCenter.getLocation().getCity()) && dealerCenter.isOpen()) {
                dealerCenterDTOList.add(dealerCenterDTOConverter.convertToDTO(dealerCenter));
            }
        }
        return dealerCenterDTOList;
    }

    @Override
    public List<DealerCenter> fetchAllDealersByCountry(String country) {
        List<DealerCenter> dealerCenterList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findAll()) {
            if (country.equals(dealerCenter.getLocation().getCountry())) {
                dealerCenterList.add(dealerCenter);
            }
        }
        return dealerCenterList;
    }

    @Override
    public List<DealerCenter> fetchAllDealersByCity(String city) {
        List<DealerCenter> dealerCenterList = new ArrayList<>();
        for (DealerCenter dealerCenter : dealerCenterRepository.findAll()) {
            if (city.equals(dealerCenter.getLocation().getCity())) {
                dealerCenterList.add(dealerCenter);
            }
        }
        return dealerCenterList;
    }
}