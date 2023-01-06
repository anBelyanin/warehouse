package org.core.entities.warehouse;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "warehouse", name = "sections")
public class SectionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sections_pk_seq")
    @SequenceGenerator(sequenceName = "sections_pk_seq", name = "sections_pk_seq", allocationSize = 10)
    @Column(name = "id")
    private Long id;

    @Column(name = "area_id")
    private Long areaId;

    @Column(name = "name")
    private String name;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "section_id", fetch = FetchType.EAGER)
    private List<PlaceEntity> places;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
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

    public List<PlaceEntity> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceEntity> places) {
        this.places = places;
    }
}
