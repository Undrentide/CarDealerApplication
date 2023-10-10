package ua.undrentide.cardealer.api.converter;

import java.util.List;

public interface EntityDTOConverter<E, DTO> {
    DTO convertToDTO(E entity);

    E convertToEntity (DTO consultantDTO);

    List<DTO> convertAllToDto(List<E> entityList);
}