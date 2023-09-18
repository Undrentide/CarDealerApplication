package carDealerApplication.api.controller;

import carDealerApplication.api.dto.AdministratorDTO;
import carDealerApplication.api.dto.ConsultantDTO;
import carDealerApplication.api.validator.AdministratorApiValidator;
import carDealerApplication.entity.*;
import carDealerApplication.service.*;
import carDealerApplication.util.JwtHandlerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
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
    private final JwtHandlerUtil jwtHandlerUtil;
    private final AdministratorApiValidator administratorApiValidator;

    @GetMapping("car")
    public List<Car> fetchCarList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return carService.fetchEntityList();
    }

    @GetMapping("dealer_center")
    public List<DealerCenter> fetchDealerCenterList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return dealerCenterService.fetchEntityList();
    }

    @GetMapping("manufacturer")
    public List<Manufacturer> fetchManufacturerList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return manufacturerService.fetchEntityList();
    }

    @GetMapping("consultant")
    public List<ConsultantDTO> fetchConsultantList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return consultantService.fetchEntityList();
    }

    @GetMapping("administrator")
    public List<AdministratorDTO> fetchAdministratorList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return administratorService.fetchEntityList();
    }

    @GetMapping("special_offer")
    public List<SpecialOffer> fetchSpecialOfferList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return specialOfferService.fetchEntityList();
    }

    @GetMapping("location")
    public List<Location> fetchLocationList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return locationService.fetchEntityList();
    }

    @PutMapping("car")
    public void upsertCar(@RequestBody Car car, @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        administratorApiValidator.validateCar(car);
        carService.upsertEntity(car);
    }

    @PutMapping("dealer_center")
    public void upsertDealerCenter(@RequestBody DealerCenter dealerCenter,
                                   @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        administratorApiValidator.validateDealerCenter(dealerCenter);
        dealerCenterService.upsertEntity(dealerCenter);
    }

    @PutMapping("manufacturer")
    public void upsertManufacturer(@RequestBody Manufacturer manufacturer,
                                   @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        administratorApiValidator.validateManufacturer(manufacturer);
        manufacturerService.upsertEntity(manufacturer);
    }

    @PutMapping("consultant")
    public void upsertConsultant(@RequestBody ConsultantDTO consultantDTO,
                                 @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        administratorApiValidator.validateConsultant(consultantDTO);
        consultantService.upsertEntity(consultantDTO);
    }

    @PutMapping("administrator")
    public void upsertAdministrator(@RequestBody AdministratorDTO administratorDTO,
                                    @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        administratorApiValidator.validateAdministrator(administratorDTO);
        administratorService.upsertEntity(administratorDTO);
    }

    @PutMapping("special_offer")
    public void upsertSpecialOffer(@RequestBody SpecialOffer specialOffer,
                                   @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        administratorApiValidator.validateSpecialOffer(specialOffer);
        specialOfferService.upsertEntity(specialOffer);
    }

    @DeleteMapping("car/delete/{id}")
    public String deleteCar(@PathVariable("id") Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        carService.deleteEntityById(id);
        return "This car was successfully deleted for good";
    }

    @DeleteMapping("dealer_center/delete/{id}")
    public String deleteDealerCenter(@PathVariable("id") Long id,
                                     @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        dealerCenterService.deleteEntityById(id);
        return "This dealer center was successfully deleted for good";
    }

    @DeleteMapping("manufacturer/delete/{id}")
    public String deleteManufacturer(@PathVariable("id") Long id,
                                     @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        manufacturerService.deleteEntityById(id);
        return "This manufacturer was successfully deleted for good";
    }

    @DeleteMapping("consultant/delete/{id}")
    public String deleteConsultant(@PathVariable("id") Long id,
                                   @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        consultantService.deleteEntityById(id);
        return "This consultant was successfully erased for good";
    }

    @DeleteMapping("administrator/delete/{id}")
    public String deleteAdministrator(@PathVariable("id") Long id,
                                      @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        administratorService.deleteEntityById(id);
        return "This administrator was successfully erased for good";
    }

    @DeleteMapping("special_offer/delete/{id}")
    public String deleteSpecialOffer(@PathVariable("id") Long id,
                                     @RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        specialOfferService.deleteEntityById(id);
        return "This car was successfully deleted for good";
    }
}