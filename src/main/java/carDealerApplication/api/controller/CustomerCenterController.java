package carDealerApplication.api.controller;

import carDealerApplication.api.dto.CarDTO;
import carDealerApplication.api.dto.DealerCenterDTO;
import carDealerApplication.service.CarService;
import carDealerApplication.service.DealerCenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("dealer_center")
public class CustomerCenterController {
    private final DealerCenterService dealerCenterService;
    private final CarService carService;

    @GetMapping("car")
    public List<CarDTO> fetchCarsList(@RequestParam(required = false, defaultValue = "1") int page,
                                      @RequestParam(required = false, defaultValue = "1") int size,
                                      @RequestParam(required = false, defaultValue = "hours") String sortOrder) {
        return carService.limitedFetchAvailableCars(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("legal_info")
    public String takeLegalInformation() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n" +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    }

    @GetMapping("lending_info")
    public String takeLendingInformation() {
        return "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\n" +
                "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\n" +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.\n" +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    }

    @GetMapping("find_my_dealer/country/{country}")
    public List<DealerCenterDTO> fetchDealersByCountry(@PathVariable("country") String country,
                                                       @RequestParam(required = false, defaultValue = "1") int page,
                                                       @RequestParam(required = false, defaultValue = "1") int size,
                                                       @RequestParam(required = false, defaultValue = "hours") String sortOrder) {
        return dealerCenterService.fetchOpenedDealersByCountry(country, PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("find_my_dealer/city/{city}")
    public List<DealerCenterDTO> fetchDealersByCity(@PathVariable("city") String city,
                                                    @RequestParam(required = false, defaultValue = "1") int page,
                                                    @RequestParam(required = false, defaultValue = "1") int size,
                                                    @RequestParam(required = false, defaultValue = "hours") String sortOrder) {
        return dealerCenterService.fetchOpenedDealersByCity(city, PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }
}