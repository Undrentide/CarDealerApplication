package carDealerApplication.api.controller;

import carDealerApplication.entity.Administrator;
import carDealerApplication.entity.Consultant;
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
    private final ConsultantJwtGenerator consultantJwtGenerator;
    private final AdministratorJwtGenerator administratorJwtGenerator;

    @PostMapping("consultant")
    public ResponseEntity<?> loginConsultant(@RequestBody Consultant consultant) {
        return new ResponseEntity<>(consultantJwtGenerator.entityJwtGenerateToken(consultant), HttpStatus.OK);
    }

    @PostMapping("administrator")
    public ResponseEntity<?> loginAdministrator(@RequestBody Administrator administrator) {
        return new ResponseEntity<>(administratorJwtGenerator.entityJwtGenerateToken(administrator), HttpStatus.OK);
    }
}