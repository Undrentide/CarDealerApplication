package carDealerApplication.service.impl;

import carDealerApplication.dal.LocationRepository;
import carDealerApplication.dal.SpecialOfferRepository;
import carDealerApplication.entity.SpecialOffer;
import carDealerApplication.exception.EntityNotFoundException;
import carDealerApplication.service.SpecialOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<SpecialOffer> fetchEntityList(PageRequest pageRequest) {
        return new ArrayList<>(specialOfferRepository.findAll(pageRequest).getContent());
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
    public List<SpecialOffer> fetchSpecialOffersByCountry(String country, PageRequest pageRequest) {
        return new ArrayList<>(specialOfferRepository.findSpecialOfferByCountriesIn(locationRepository.getLocationsByCountry(country, pageRequest)));
    }
}