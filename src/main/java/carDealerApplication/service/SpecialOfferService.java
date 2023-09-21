package carDealerApplication.service;

import carDealerApplication.entity.SpecialOffer;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface SpecialOfferService extends EntityService<SpecialOffer, Long> {
    List<SpecialOffer> fetchSpecialOfferByCountry(String country, PageRequest pageRequest);
}