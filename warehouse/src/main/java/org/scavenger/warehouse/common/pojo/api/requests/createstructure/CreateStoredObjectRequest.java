package org.scavenger.warehouse.common.pojo.api.requests.createstructure;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Convert;
import org.springframework.data.convert.Jsr310Converters;

import java.time.LocalDate;

@JsonPropertyOrder({
        "areaName",
        "sectionName",
        "placeName",
        "name",
        "typeName",
        "receiptDate",
        "receiptEmployeeName"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateStoredObjectRequest {

    @JsonProperty(value = "areaName", required = true)
    private String areaName;

    @JsonProperty(value = "sectionName", required = true)
    private String sectionName;

    @JsonProperty(value = "placeName", required = true)
    private String placeName;

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "typeName", required = true)
    private String typeName;

    @JsonProperty(value = "receiptDate", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate receiptDate;

    @JsonProperty(value = "receiptEmployeeName", required = true)
    private String receiptEmployeeName;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public LocalDate getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(LocalDate receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceiptEmployeeName() {
        return receiptEmployeeName;
    }

    public void setReceiptEmployeeName(String receiptEmployeeName) {
        this.receiptEmployeeName = receiptEmployeeName;
    }
}
