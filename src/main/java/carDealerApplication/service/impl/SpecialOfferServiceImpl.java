package carDealerApplication.service.impl;

import carDealerApplication.dal.LocationRepository;
import carDealerApplication.dal.SpecialOfferRepository;
import carDealerApplication.entity.SpecialOffer;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.service.SpecialOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialOfferServiceImpl implements SpecialOfferService {
    private final SpecialOfferRepository specialOfferRepository;
    private final LocationRepository locationRepository;

    @Override
    public void upsertEntity(SpecialOffer specialOffer) {
        specialOfferRepository.save(specialOffer);
    }

    @Override
    public List<SpecialOffer> fetchEntityList() {
        return new ArrayList<>((Collection<? extends SpecialOffer>) specialOfferRepository.findAll());
    }

    @Override
    public void deleteEntityById(Long specialOfferId) {
        if (specialOfferRepository.existsById(specialOfferId)) {
            specialOfferRepository.deleteById(specialOfferId);
        } else {
            throw new EntityNotFoundException("Special offer not found.");
        }
    }

    @Override
    public List<SpecialOffer> fetchSpecialOfferByCountry(String country) {
        return new ArrayList<>(specialOfferRepository.findSpecialOfferByCountriesIn(locationRepository.getLocationsByCountry(country)));
    }

}