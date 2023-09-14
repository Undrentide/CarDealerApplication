package carDealerApplication.service;

import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.entity.DealerCenter;

import java.util.List;

public interface DealerCenterService extends EntityService<DealerCenter, Long> {
    List<DealerCenterDTO> fetchOpenedDealersByCountry(String country);

    List<DealerCenterDTO> fetchOpenedDealersByCity(String city);

    List<DealerCenter> fetchAllDealersByCountry(String country);

    List<DealerCenter> fetchAllDealersByCity(String city);
}