package ua.undrentide.cardealer.service;

import ua.undrentide.cardealer.entity.SpecialOffer;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface SpecialOfferService extends EntityService<SpecialOffer, Long> {
    List<SpecialOffer> fetchSpecialOffersByCountry(String country, PageRequest pageRequest);
}