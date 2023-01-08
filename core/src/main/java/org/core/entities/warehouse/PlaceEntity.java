package org.core.entities.warehouse;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(schema = "warehouse", name = "places")
public class PlaceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "places_pk_seq")
    @SequenceGenerator(sequenceName = "warehouse.places_pk_seq", name = "places_pk_seq", allocationSize = 10)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "section_id")
    private Long sectionId;

    @Column(name = "notes")
    private String notes;

    @OneToMany(mappedBy = "placeId", fetch = FetchType.EAGER)
    private List<StoredObjectEntity> storedObjects;

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

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<StoredObjectEntity> getStoredObjects() {
        return storedObjects;
    }

    public void setStoredObjects(List<StoredObjectEntity> storedObjects) {
        this.storedObjects = storedObjects;
    }
}
