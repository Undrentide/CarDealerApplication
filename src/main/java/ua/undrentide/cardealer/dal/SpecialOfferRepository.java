package ua.undrentide.cardealer.dal;

import ua.undrentide.cardealer.entity.Location;
import ua.undrentide.cardealer.entity.SpecialOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Long> {
    List<SpecialOffer> findSpecialOfferByCountriesIn(List<Location> countries);

    List<SpecialOffer> findAll();
}