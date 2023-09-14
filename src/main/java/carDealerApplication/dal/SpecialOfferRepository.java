package carDealerApplication.dal;

import carDealerApplication.entity.SpecialOffer;
import org.springframework.data.repository.CrudRepository;

public interface SpecialOfferRepository extends CrudRepository<SpecialOffer, Long> {
}