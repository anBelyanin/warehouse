package org.core.repositories.warehouse;

import org.core.entities.warehouse.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacesRepository extends JpaRepository<PlaceEntity, Long> {
}
