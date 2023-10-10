package ua.undrentide.cardealer.service.impl;

import ua.undrentide.cardealer.dal.LocationRepository;
import ua.undrentide.cardealer.dal.SpecialOfferRepository;
import ua.undrentide.cardealer.entity.SpecialOffer;
import ua.undrentide.cardealer.exception.EntityNotFoundException;
import ua.undrentide.cardealer.service.SpecialOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
        return specialOfferRepository.findAll(pageRequest).getContent();
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
        List<SpecialOffer> specialOfferByCountriesInList = specialOfferRepository
                .findSpecialOfferByCountriesIn(locationRepository.getLocationsByCountry(country, pageRequest));
        if (specialOfferByCountriesInList.isEmpty()) {
            throw new EntityNotFoundException("Special offers for this country are not available");
        }
        return specialOfferByCountriesInList;
    }
}