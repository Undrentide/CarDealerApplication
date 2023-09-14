package carDealerApplication.service;

import java.util.List;

public interface EntityService<E, ID> {
    void upsertEntity(E entity);

    List<E> fetchEntityList();

    void deleteEntityById(ID entityId);
}