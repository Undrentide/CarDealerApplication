package ua.undrentide.cardealer.api.controller;

import ua.undrentide.cardealer.api.dto.AdministratorDTO;
import ua.undrentide.cardealer.api.dto.ConsultantDTO;
import ua.undrentide.cardealer.service.AdministratorService;
import ua.undrentide.cardealer.service.ConsultantService;
import ua.undrentide.cardealer.service.UserJwtGenerator;
import ua.undrentide.cardealer.api.converter.impl.AdministratorDTOConverter;
import ua.undrentide.cardealer.api.converter.impl.ConsultantDTOConverter;
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
    private final UserJwtGenerator userJwtGenerator;
    private final ConsultantDTOConverter consultantDTOConverter;
    private final AdministratorDTOConverter administratorDTOConverter;

    @PostMapping("consultant")
    public ResponseEntity<?> loginConsultant(@RequestBody ConsultantDTO consultantDTO) {
        return new ResponseEntity<>(userJwtGenerator.userJwtGenerateToken(consultantDTOConverter
                .convertToEntity(consultantService.authenticate(consultantDTO))), HttpStatus.OK);
    }

    @PostMapping("administrator")
    public ResponseEntity<?> loginAdministrator(@RequestBody AdministratorDTO administratorDTO) {
        return new ResponseEntity<>(userJwtGenerator.userJwtGenerateToken(administratorDTOConverter
                .convertToEntity(administratorService.authenticate(administratorDTO))), HttpStatus.OK);
    }
}