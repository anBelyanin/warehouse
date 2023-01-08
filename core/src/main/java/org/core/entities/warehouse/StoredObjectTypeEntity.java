package org.core.entities.warehouse;

import jakarta.persistence.*;

@Entity
@Table(schema = "warehouse", name = "stored_objects_types")
public class StoredObjectTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stored_objects_type_pk_seq")
    @SequenceGenerator(sequenceName = "warehouse.stored_objects_type_pk_seq", name = "stored_objects_type_pk_seq", allocationSize = 5)
    @Column(name = "id")
    private Long id;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "notes")
    private String notes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
