package org.scavenger.warehouse.common.pojo.api.responses.createstructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseResponse;

@JsonPropertyOrder({
        "name",
        "notes"
})
public class CreateStoredObjectTypeResponse extends WarehouseResponse {

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "notes", required = true)
    private String notes;

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
}
