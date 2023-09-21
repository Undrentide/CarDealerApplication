package carDealerApplication.service;

import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface EntityService<E, ID> {
    void upsertEntity(E entity);

    List<E> fetchEntityList(PageRequest pageRequest);

    void deleteEntityById(ID entityId);
}