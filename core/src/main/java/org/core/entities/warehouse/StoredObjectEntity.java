package org.core.entities.warehouse;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(schema = "warehouse", name = "stored_objects")
public class StoredObjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stored_objects_pk_seq")
    @SequenceGenerator(name = "stored_objects_pk_seq", sequenceName = "warehouse.stored_objects_pk_seq", allocationSize = 10)
    private Long id;

    @Column(name = "place_id")
    private Long placeId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private StoredObjectTypeEntity storedObjectType;

    @Column(name = "receipt_date")
    private LocalDate receiptDate;

    @Column(name = "receipt_employee_id")
    private Long receiptEmployeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StoredObjectTypeEntity getStoredObjectType() {
        return storedObjectType;
    }

    public void setStoredObjectType(StoredObjectTypeEntity storedObjectType) {
        this.storedObjectType = storedObjectType;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Long getReceiptEmployeeId() {
        return receiptEmployeeId;
    }

    public void setReceiptEmployeeId(Long receiptEmployeeId) {
        this.receiptEmployeeId = receiptEmployeeId;
    }
}
