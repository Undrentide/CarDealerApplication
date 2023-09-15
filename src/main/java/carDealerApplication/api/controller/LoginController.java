package carDealerApplication.api.controller;

import carDealerApplication.api.dto.AdministratorDTO;
import carDealerApplication.api.dto.ConsultantDTO;
import carDealerApplication.service.AdministratorService;
import carDealerApplication.service.ConsultantService;
import carDealerApplication.service.dtoConverter.AdministratorDTOConverter;
import carDealerApplication.service.dtoConverter.ConsultantDTOConverter;
import carDealerApplication.service.jwtGenerator.AdministratorJwtGenerator;
import carDealerApplication.service.jwtGenerator.ConsultantJwtGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("login")
public class LoginController {
    private final ConsultantService consultantService;
    private final AdministratorService administratorService;
    private final ConsultantJwtGenerator consultantJwtGenerator;
    private final AdministratorJwtGenerator administratorJwtGenerator;
    private final ConsultantDTOConverter consultantDTOConverter;
    private final AdministratorDTOConverter administratorDTOConverter;

    @PostMapping("consultant")
    public ResponseEntity<?> loginConsultant(@RequestBody ConsultantDTO consultantDTO) {
        return new ResponseEntity<>(consultantJwtGenerator.entityJwtGenerateToken(consultantDTOConverter.convertToEntity(consultantService.authenticate(consultantDTO))), HttpStatus.OK);
    }

    @PostMapping("administrator")
    public ResponseEntity<?> loginAdministrator(@RequestBody AdministratorDTO administratorDTO) {
        return new ResponseEntity<>(administratorJwtGenerator.entityJwtGenerateToken(administratorDTOConverter.convertToEntity(administratorService.authenticate(administratorDTO))), HttpStatus.OK);
    }
}