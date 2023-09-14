package carDealerApplication.service;

import carDealerApplication.entity.SpecialOffer;

import java.util.List;

public interface SpecialOfferService extends EntityService<SpecialOffer, Long> {
    List<SpecialOffer> fetchSpecialOfferByCountry(String country);
}