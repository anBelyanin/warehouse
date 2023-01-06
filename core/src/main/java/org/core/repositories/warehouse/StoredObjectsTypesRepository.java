package org.core.repositories.warehouse;

import org.core.entities.warehouse.StoredObjectTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredObjectsTypesRepository extends JpaRepository<StoredObjectTypeEntity, Long> {
}
