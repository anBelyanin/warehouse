package org.core.entities.warehouse;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "warehouse", name = "areas")
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "areas_pk_seq")
    @SequenceGenerator(sequenceName = "areas_pk_seq", name = "areas_pk_seq", allocationSize = 10)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "area_id", fetch = FetchType.EAGER)
    private List<SectionEntity> sectionEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<SectionEntity> getSections() {
        return sectionEntities;
    }

    public void setSections(List<SectionEntity> sectionEntities) {
        this.sectionEntities = sectionEntities;
    }
}
