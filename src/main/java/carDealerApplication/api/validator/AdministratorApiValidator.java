package carDealerApplication.api.validator;

import carDealerApplication.api.dto.AdministratorDTO;
import carDealerApplication.api.dto.ConsultantDTO;
import carDealerApplication.entity.Car;
import carDealerApplication.entity.DealerCenter;
import carDealerApplication.entity.Manufacturer;
import carDealerApplication.entity.SpecialOffer;
import org.springframework.stereotype.Component;

@Component
public class AdministratorApiValidator {
    public void validateCar(Car car) {
        if (car.getEngine() == null || car.getColor() == null || car.getBrand() == null
                || car.getCountry() == null || car.getPrice() == 0) {
            throw new IllegalArgumentException("Engine, color, brand, country and price - shouldn't be empty");
        } else if (!car.getColor().chars().allMatch(Character::isLetter) ||
                car.getBrand().chars().allMatch(Character::isLetter) || car.getCountry().chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("Engine, color, brand, country - only letters are acceptable");
        }
    }

    public void validateDealerCenter(DealerCenter dealerCenter) {
        if (dealerCenter.getLocation() == null || dealerCenter.getHours() == null ||
                dealerCenter.getConsultantList() == null || dealerCenter.getCarList() == null) {
            throw new IllegalArgumentException("Location, working hours, consultant list and car list - shouldn't be empty");
        }
    }

    public void validateManufacturer(Manufacturer manufacturer) {
        if (manufacturer.getName() == null || manufacturer.getCountry() == null || manufacturer.getOrigination() == null ||
                manufacturer.getOrigination() <= 1850) {
            throw new IllegalArgumentException("Name and country - shouldn't be empty, origination year - not null and above 1850");
        } else if (!manufacturer.getName().chars().allMatch(Character::isLetter) ||
                manufacturer.getCountry().chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("Engine, color, brand, country - only letters are acceptable");
        }
    }

    public void validateConsultant(ConsultantDTO consultantDTO) {
        if (consultantDTO.firstName == null || consultantDTO.lastName == null || consultantDTO.phone == null ||
                consultantDTO.phone == 0 || consultantDTO.login == null || consultantDTO.password == null ||
                consultantDTO.rate == null || consultantDTO.manufacturer == null) {
            throw new IllegalArgumentException("First name, last name, phone number, login, password, rate and manufacturer id - shouldn't be empty");
        } else if (!consultantDTO.firstName.chars().allMatch(Character::isLetter) || consultantDTO.lastName.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("First name, last name - only letters are acceptable");
        }
    }

    public void validateAdministrator(AdministratorDTO administratorDTO) {
        if (administratorDTO.firstName == null || administratorDTO.lastName == null || administratorDTO.phone == null ||
                administratorDTO.phone == 0 || administratorDTO.login == null || administratorDTO.password == null ||
                administratorDTO.dealerCenterList == null) {
            throw new IllegalArgumentException("First name, last name, phone number, login, password and dealer center list - shouldn't be empty");
        } else if (!administratorDTO.firstName.chars().allMatch(Character::isLetter) || administratorDTO.lastName.chars().allMatch(Character::isLetter)) {
            throw new IllegalArgumentException("First name, last name - only letters are acceptable");
        }
    }

    public void validateSpecialOffer(SpecialOffer specialOffer) {
        if (specialOffer.getCountries() == null || specialOffer.getAmount() == null || specialOffer.getAmount() <= 0 ||
                specialOffer.getDescription() == null) {
            throw new IllegalArgumentException("Country list and description - shouldn't be empty, amount - above 0");
        }
    }
}