package carDealerApplication.dal;

import carDealerApplication.entity.Location;
import carDealerApplication.entity.SpecialOffer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SpecialOfferRepository extends CrudRepository<SpecialOffer, Long> {
    List<SpecialOffer> findSpecialOfferByCountriesIn(List<Location> countries);
}