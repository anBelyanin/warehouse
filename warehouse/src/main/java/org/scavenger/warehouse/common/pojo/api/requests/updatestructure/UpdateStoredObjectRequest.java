package org.scavenger.warehouse.common.pojo.api.requests.updatestructure;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

@JsonPropertyOrder({
        "areaName",
        "sectionName",
        "placeName",
        "name",
        "newAreaName",
        "newSectionName",
        "newPlaceName",
        "newName",
        "newNotes",
        "newReceiptDate",
        "newReceiptEmployeeName",
        "newTypeName"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateStoredObjectRequest {

    @JsonProperty(value = "areaName", required = true)
    private String areaName;

    @JsonProperty(value = "sectionName", required = true)
    private String sectionName;

    @JsonProperty(value = "placeName", required = true)
    private String placeName;

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "newAreaName")
    private String newAreaName;

    @JsonProperty(value = "newSectionName")
    private String newSectionName;

    @JsonProperty(value = "newPLaceName")
    private String newPlaceName;

    @JsonProperty(value = "newName")
    private String newName;

    @JsonProperty(value = "newNotes")
    private String newNotes;

    @JsonProperty(value = "newReceiptDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate newReceiptDate;

    @JsonProperty(value = "newReceiptEmployeeName")
    private String newReceiptEmployeeName;

    @JsonProperty(value = "newTypeName")
    private String newTypeName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getNewNotes() {
        return newNotes;
    }

    public void setNewNotes(String newNotes) {
        this.newNotes = newNotes;
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

    public String getNewTypeName() {
        return newTypeName;
    }

    public void setNewTypeName(String newTypeName) {
        this.newTypeName = newTypeName;
    }
}
