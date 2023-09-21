package carDealerApplication.dal;

import carDealerApplication.entity.Location;
import carDealerApplication.entity.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Long> {
    List<SpecialOffer> findSpecialOfferByCountriesIn(List<Location> countries);

    List<SpecialOffer> findAll();
}