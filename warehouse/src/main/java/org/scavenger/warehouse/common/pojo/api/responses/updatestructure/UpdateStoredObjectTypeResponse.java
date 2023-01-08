package org.scavenger.warehouse.common.pojo.api.responses.updatestructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseResponse;

@JsonPropertyOrder({
        "newName",
        "newNotes"
})
public class UpdateStoredObjectTypeResponse extends WarehouseResponse {

    @JsonProperty(value = "newName")
    private String newName;

    @JsonProperty(value = "newNotes")
    private String newNotes;

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
}
