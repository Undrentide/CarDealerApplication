package carDealerApplication.api.controller;

import carDealerApplication.entity.Car;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.entity.SpecialOffer;
import carDealerApplication.service.CarService;
import carDealerApplication.service.DealerCenterService;
import carDealerApplication.service.SpecialOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("consultant")
public class ConsultantController {
    private final CarService carService;
    private final DealerCenterService dealerCenterService;
    private final SpecialOfferService specialOfferService;

    @GetMapping("available_car")
    public List<Car> fetchAvailableCarList() {
        return carService.fetchAvailableCar();
    }

    @GetMapping("unavailable_car")
    public List<Car> fetchUnavailableCarList() {
        return carService.fetchUnavailableCar();
    }

    @GetMapping("all_dealers/{country}")
    public List<DealerCenter> fetchAllDealersByCountry(@PathVariable("country") String country) {
        return dealerCenterService.fetchAllDealersByCountry(country);
    }

    @GetMapping("all_dealers/{city}")
    public List<DealerCenter> fetchAllDealersByCity(@PathVariable("city") String city) {
        return dealerCenterService.fetchAllDealersByCity(city);
    }

    @GetMapping("special_offer/{country}")
    public List<SpecialOffer> fetchSpecialOffersByCountry(@PathVariable("country") String country) {
        return specialOfferService.fetchSpecialOfferByCountry(country);
    }
}