package ua.undrentide.cardealer.service;

import ua.undrentide.cardealer.api.dto.AdministratorDTO;

public interface AdministratorService extends EntityService<AdministratorDTO, Long> {
    AdministratorDTO authenticate(AdministratorDTO administratorDTO);
}