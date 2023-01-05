package org.scavenger.warehouse.common.pojo.structure;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonPropertyOrder({
        "name",
        "type",
        "receiptDate",
        "receivingEmployeeName",
        "notes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoredObject {

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "type", required = true)
    private String type;

    @JsonProperty(value = "receiptDate", required = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date receiptDate;

    @JsonProperty(value = "receivingEmployeeName", required = true)
    private String receivingEmployeeName;

    @JsonProperty(value = "notes")
    private String notes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getReceivingEmployeeName() {
        return receivingEmployeeName;
    }

    public void setReceivingEmployeeName(String receivingEmployeeName) {
        this.receivingEmployeeName = receivingEmployeeName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
