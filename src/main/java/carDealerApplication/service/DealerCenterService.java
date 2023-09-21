package carDealerApplication.service;

import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.entity.DealerCenter;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface DealerCenterService extends EntityService<DealerCenter, Long> {
    List<DealerCenterDTO> fetchOpenedDealersByCountry(String country, PageRequest pageRequest);

    List<DealerCenterDTO> fetchOpenedDealersByCity(String city, PageRequest pageRequest);

    List<DealerCenter> fetchAllDealersByCountry(String country, PageRequest pageRequest);

    List<DealerCenter> fetchAllDealersByCity(String city, PageRequest pageRequest);
}