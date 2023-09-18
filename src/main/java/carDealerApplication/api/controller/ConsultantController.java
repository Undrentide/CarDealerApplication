package carDealerApplication.api.controller;

import carDealerApplication.entity.Car;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.entity.SpecialOffer;
import carDealerApplication.service.CarService;
import carDealerApplication.service.DealerCenterService;
import carDealerApplication.service.SpecialOfferService;
import carDealerApplication.util.JwtHandlerUtil;
import lombok.RequiredArgsConstructor;
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
    public List<Car> fetchAvailableCarList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return carService.fetchAvailableCar();
    }

    @GetMapping("unavailable_car")
    public List<Car> fetchUnavailableCarList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return carService.fetchUnavailableCar();
    }

    @GetMapping("all_dealers/country/{country}")
    public List<DealerCenter> fetchAllDealersByCountry(@PathVariable("country") String country,
                                                       @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return dealerCenterService.fetchAllDealersByCountry(country);
    }

    @GetMapping("all_dealers/city/{city}")
    public List<DealerCenter> fetchAllDealersByCity(@PathVariable("city") String city,
                                                    @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return dealerCenterService.fetchAllDealersByCity(city);
    }

    @GetMapping("special_offer/{country}")
    public List<SpecialOffer> fetchSpecialOffersByCountry(@PathVariable("country") String country,
                                                          @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForConsultant(jwtToken);
        return specialOfferService.fetchSpecialOfferByCountry(country);
    }
}