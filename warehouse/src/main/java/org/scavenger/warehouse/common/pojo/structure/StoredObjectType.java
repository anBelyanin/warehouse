package org.scavenger.warehouse.common.pojo.structure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "typeName",
        "notes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoredObjectType {

    @JsonProperty(value = "typeName", required = true)
    private String typeName;

    @JsonProperty(value = "notes")
    private String notes;

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
