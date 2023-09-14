package carDealerApplication.service.dtoConverter;

public interface EntityDTOConverter<E, DTO> {
    DTO convertToDTO(E entity);
}