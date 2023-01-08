package org.core.repositories.warehouse;

import org.core.entities.warehouse.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionsRepository extends JpaRepository<SectionEntity, Long> {

    SectionEntity findByName(String name);

    List<SectionEntity> findByAreaId(Long areaId);

    SectionEntity findByNameAndAreaId(String name, Long areaId);
}
