package org.scavenger.warehouse.common.pojo.api.responses.updatestructure;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseResponse;

import java.time.LocalDate;

@JsonPropertyOrder({
        "newAreaName",
        "newSectionName",
        "newPlaceName",
        "newName",
        "newTypeName",
        "newReceiptDate",
        "newReceiptEmployeeName"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateStoredObjectResponse extends WarehouseResponse {

    @JsonProperty(value = "newAreaName")
    private String newAreaName;

    @JsonProperty(value = "newSectionName")
    private String newSectionName;

    @JsonProperty(value = "newPlaceName")
    private String newPlaceName;

    @JsonProperty(value = "newName")
    private String newName;

    @JsonProperty(value = "newTypeName")
    private String newTypeName;

    @JsonProperty(value = "newReceiptDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate newReceiptDate;

    @JsonProperty(value = "newReceiptEmployeeName")
    private String newReceiptEmployeeName;

    public String getNewAreaName() {
        return newAreaName;
    }

    public void setNewAreaName(String newAreaName) {
        this.newAreaName = newAreaName;
    }

    public String getNewSectionName() {
        return newSectionName;
    }

    public void setNewSectionName(String newSectionName) {
        this.newSectionName = newSectionName;
    }

    public String getNewPlaceName() {
        return newPlaceName;
    }

    public void setNewPlaceName(String newPlaceName) {
        this.newPlaceName = newPlaceName;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewTypeName() {
        return newTypeName;
    }

    public void setNewTypeName(String newTypeName) {
        this.newTypeName = newTypeName;
    }

    public LocalDate getNewReceiptDate() {
        return newReceiptDate;
    }

    public void setNewReceiptDate(LocalDate newReceiptDate) {
        this.newReceiptDate = newReceiptDate;
    }

    public String getNewReceiptEmployeeName() {
        return newReceiptEmployeeName;
    }

    public void setNewReceiptEmployeeName(String newReceiptEmployeeName) {
        this.newReceiptEmployeeName = newReceiptEmployeeName;
    }
}
