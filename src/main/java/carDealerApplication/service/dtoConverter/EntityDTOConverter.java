package carDealerApplication.service.dtoConverter;

import java.util.List;

public interface EntityDTOConverter<E, DTO> {
    DTO convertToDTO(E entity);

    E convertToEntity (DTO consultantDTO);

    List<DTO> convertAllToDto(List<E> entityList);

    List<E> convertAllToEntity(List<DTO> dtoList);
}