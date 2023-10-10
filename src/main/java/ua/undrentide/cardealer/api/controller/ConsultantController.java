package ua.undrentide.cardealer.api.controller;

import ua.undrentide.cardealer.entity.Car;
import ua.undrentide.cardealer.entity.DealerCenter;
import ua.undrentide.cardealer.entity.SpecialOffer;
import ua.undrentide.cardealer.service.CarService;
import ua.undrentide.cardealer.service.DealerCenterService;
import ua.undrentide.cardealer.service.SpecialOfferService;
import ua.undrentide.cardealer.util.JwtHandlerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("consultant")
public class ConsultantController {
    private final CarService carService;
    private final DealerCenterService dealerCenterService;
    private final SpecialOfferService specialOfferService;
    private final JwtHandlerUtil jwtHandlerUtil;

    @GetMapping("available_car")
    public List<Car> fetchAvailableCarsList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                            @RequestParam(required = false, defaultValue = "0") int page,
                                            @RequestParam(required = false, defaultValue = "2") int size,
                                            @RequestParam(required = false, defaultValue = "price") String sortOrder) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return carService.fetchAvailableCars(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("unavailable_car")
    public List<Car> fetchUnavailableCarsList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                              @RequestParam(required = false, defaultValue = "0") int page,
                                              @RequestParam(required = false, defaultValue = "2") int size,
                                              @RequestParam(required = false, defaultValue = "price") String sortOrder) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return carService.fetchUnavailableCars(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("all_dealers/country/{country}")
    public List<DealerCenter> fetchAllDealersByCountry(@PathVariable("country") String country,
                                                       @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                       @RequestParam(required = false, defaultValue = "0") int page,
                                                       @RequestParam(required = false, defaultValue = "1") int size,
                                                       @RequestParam(required = false, defaultValue = "openHours") String sortOrder) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return dealerCenterService.fetchAllDealersByCountry(country, PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("all_dealers/city/{city}")
    public List<DealerCenter> fetchAllDealersByCity(@PathVariable("city") String city,
                                                    @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                    @RequestParam(required = false, defaultValue = "0") int page,
                                                    @RequestParam(required = false, defaultValue = "1") int size,
                                                    @RequestParam(required = false, defaultValue = "openHours") String sortOrder) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return dealerCenterService.fetchAllDealersByCity(city, PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("special_offer/{country}")
    public List<SpecialOffer> fetchSpecialOffersByCountry(@PathVariable("country") String country,
                                                          @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                          @RequestParam(required = false, defaultValue = "0") int page,
                                                          @RequestParam(required = false, defaultValue = "1") int size,
                                                          @RequestParam(required = false, defaultValue = "city") String sortOrder) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return specialOfferService.fetchSpecialOffersByCountry(country, PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }
}