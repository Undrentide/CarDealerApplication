package carDealerApplication.service.impl;

import carDealerApplication.dal.SpecialOfferRepository;
import carDealerApplication.entity.Location;
import carDealerApplication.entity.SpecialOffer;
import carDealerApplication.service.SpecialOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialOfferServiceImpl implements SpecialOfferService {
    private final SpecialOfferRepository specialOfferRepository;

    @Override
    public void upsertEntity(SpecialOffer specialOffer) {
        specialOfferRepository.save(specialOffer);
    }

    @Override
    public List<SpecialOffer> fetchEntityList() {
        List<SpecialOffer> specialOfferList = new ArrayList<>();
        for (SpecialOffer specialOffer : specialOfferRepository.findAll()) {
            specialOfferList.add(specialOffer);
        }
        return specialOfferList;
    }

    @Override
    public void deleteEntityById(Long specialOfferId) {
        specialOfferRepository.deleteById(specialOfferId);
    }

    @Override
    public List<SpecialOffer> fetchSpecialOfferByCountry(String country) {
        List<SpecialOffer> specialOfferList = new ArrayList<>();
        for (SpecialOffer specialOffer : specialOfferRepository.findAll()) {
            for (Location location : specialOffer.getCountries()) {
                if (country.equals(location.getCountry())) {
                    specialOfferList.add(specialOffer);
                }
            }
        }
        return specialOfferList;
    }
}