package org.core.repositories.warehouse;

import org.core.entities.warehouse.AreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreasRepository extends JpaRepository<AreaEntity, Long> {
}
