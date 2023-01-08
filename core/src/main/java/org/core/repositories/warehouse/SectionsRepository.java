package org.core.repositories.warehouse;

import org.core.entities.warehouse.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionsRepository extends JpaRepository<SectionEntity, Long> {

    SectionEntity findByName(String name);
}
