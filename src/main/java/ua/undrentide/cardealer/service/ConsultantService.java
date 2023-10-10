package ua.undrentide.cardealer.service;

import ua.undrentide.cardealer.api.dto.ConsultantDTO;

public interface ConsultantService extends EntityService<ConsultantDTO, Long> {
    ConsultantDTO authenticate(ConsultantDTO consultantDTO);
}