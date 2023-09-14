package carDealerApplication.api.controller;

import carDealerApplication.entity.*;
import carDealerApplication.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("administrator")
public class AdministratorController {
    private final CarService carService;
    private final DealerCenterService dealerCenterService;
    private final ManufacturerService manufacturerService;
    private final ConsultantService consultantService;
    private final AdministratorService administratorService;
    private final SpecialOfferService specialOfferService;
    private final LocationService locationService;

    @GetMapping("car")
    public List<Car> fetchCarList() {
        return carService.fetchEntityList();
    }

    @GetMapping("dealer_center")
    public List<DealerCenter> fetchDealerCenterList() {
        return dealerCenterService.fetchEntityList();
    }

    @GetMapping("manufacturer")
    public List<Manufacturer> fetchManufacturerList() {
        return manufacturerService.fetchEntityList();
    }

    @GetMapping("consultant")
    public List<Consultant> fetchConsultantList() {
        return consultantService.fetchEntityList();
    }

    @GetMapping("administrator")
    public List<Administrator> fetchAdministratorList() {
        return administratorService.fetchEntityList();
    }

    @GetMapping("special_offer")
    public List<SpecialOffer> fetchSpecialOfferList() {
        return specialOfferService.fetchEntityList();
    }

    @GetMapping("location")
    public List<Location> fetchLocationList() {
        return locationService.fetchEntityList();
    }

    @PutMapping("car")
    public void upsertCar(@RequestBody Car car) {
        carService.upsertEntity(car);
    }

    @PutMapping("dealer_center")
    public void upsertDealerCenter(@RequestBody DealerCenter dealerCenter) {
        dealerCenterService.upsertEntity(dealerCenter);
    }

    @PutMapping("manufacturer")
    public void upsertManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.upsertEntity(manufacturer);
    }

    @PutMapping("consultant")
    public void upsertConsultant(@RequestBody Consultant consultant) {
        consultantService.upsertEntity(consultant);
    }

    @PutMapping("administrator")
    public void upsertAdministrator(@RequestBody Administrator administrator) {
        administratorService.upsertEntity(administrator);
    }

    @PutMapping("special_offer")
    public void upsertSpecialOffer(@RequestBody SpecialOffer specialOffer) {
        specialOfferService.upsertEntity(specialOffer);
    }

    @DeleteMapping("car/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id) {
        carService.deleteEntityById(id);
        return "This car was successfully deleted for good";
    }

    @DeleteMapping("dealer_center/delete/{id}")
    public String deleteDealerCenter(@PathVariable("id") Long id) {
        dealerCenterService.deleteEntityById(id);
        return "This dealer center was successfully deleted for good";
    }

    @DeleteMapping("manufacturer/delete/{id}")
    public String deleteManufacturer(@PathVariable("id") Long id) {
        manufacturerService.deleteEntityById(id);
        return "This manufacturer was successfully deleted for good";
    }

    @DeleteMapping("consultant/delete/{id}")
    public String deleteConsultant(@PathVariable("id") Long id) {
        consultantService.deleteEntityById(id);
        return "This consultant was successfully erased for good";
    }

    @DeleteMapping("administrator/delete/{id}")
    public String deleteAdministrator(@PathVariable("id") Long id) {
        administratorService.deleteEntityById(id);
        return "This administrator was successfully erased for good";
    }

    @DeleteMapping("special_offer/delete/{id}")
    public String deleteSpecialOffer(@PathVariable("id") Long id) {
        specialOfferService.deleteEntityById(id);
        return "This car was successfully deleted for good";
    }
}