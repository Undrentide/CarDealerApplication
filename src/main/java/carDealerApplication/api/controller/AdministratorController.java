package carDealerApplication.api.controller;

import carDealerApplication.api.dto.AdministratorDTO;
import carDealerApplication.api.dto.ConsultantDTO;
import carDealerApplication.api.validator.AdministratorApiValidator;
import carDealerApplication.entity.*;
import carDealerApplication.service.*;
import carDealerApplication.util.JwtHandlerUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public List<Car> fetchCarsList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                   @RequestParam(required = false, defaultValue = "1") int page,
                                   @RequestParam(required = false, defaultValue = "1") int size,
                                   @RequestParam(required = false, defaultValue = "price") String sortOrder) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return carService.fetchEntityList(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("dealer_center")
    public List<DealerCenter> fetchDealerCentersList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                     @RequestParam(required = false, defaultValue = "1") int page,
                                                     @RequestParam(required = false, defaultValue = "1") int size,
                                                     @RequestParam(required = false, defaultValue = "hours") String sortOrder) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return dealerCenterService.fetchEntityList(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("manufacturer")
    public List<Manufacturer> fetchManufacturersList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                     @RequestParam(required = false, defaultValue = "1") int page,
                                                     @RequestParam(required = false, defaultValue = "1") int size,
                                                     @RequestParam(required = false, defaultValue = "originationYear") String sortOrder) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return manufacturerService.fetchEntityList(PageRequest.of(page, size, Sort.by(sortOrder).descending()));
    }

    @GetMapping("consultant")
    public List<ConsultantDTO> fetchConsultantsList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                    @RequestParam(required = false, defaultValue = "1") int page,
                                                    @RequestParam(required = false, defaultValue = "1") int size,
                                                    @RequestParam(required = false, defaultValue = "id") String sortOrder) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return consultantService.fetchEntityList(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("administrator")
    public List<AdministratorDTO> fetchAdministratorsList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                          @RequestParam(required = false, defaultValue = "1") int page,
                                                          @RequestParam(required = false, defaultValue = "1") int size,
                                                          @RequestParam(required = false, defaultValue = "id") String sortOrder) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return administratorService.fetchEntityList(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("special_offer")
    public List<SpecialOffer> fetchSpecialOffersList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                                     @RequestParam(required = false, defaultValue = "1") int page,
                                                     @RequestParam(required = false, defaultValue = "1") int size,
                                                     @RequestParam(required = false, defaultValue = "amount") String sortOrder) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return specialOfferService.fetchEntityList(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
    }

    @GetMapping("location")
    public List<Location> fetchLocationsList(@RequestHeader(HttpHeaders.AUTHORIZATION) String jwtToken,
                                             @RequestParam(required = false, defaultValue = "1") int page,
                                             @RequestParam(required = false, defaultValue = "1") int size,
                                             @RequestParam(required = false, defaultValue = "city") String sortOrder) {
        jwtHandlerUtil.validateJwtForAdministrator(jwtToken);
        return locationService.fetchEntityList(PageRequest.of(page, size, Sort.by(sortOrder).ascending()));
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