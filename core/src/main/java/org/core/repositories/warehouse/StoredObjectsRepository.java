package org.core.repositories.warehouse;

import org.core.entities.warehouse.StoredObjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoredObjectsRepository extends JpaRepository<StoredObjectEntity, Long> {
}
