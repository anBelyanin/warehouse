package org.scavenger.warehouse.common.pojo.api.responses.updatestructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseResponse;

@JsonPropertyOrder({
        "newSectionName",
        "newName",
        "newNotes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatePlaceResponse extends WarehouseResponse {

    @JsonProperty(value = "newSectionName")
    private String newSectionName;

    @JsonProperty(value = "newName")
    private String newName;

    @JsonProperty(value = "newNotes")
    private String newNotes;

    public String getNewSectionName() {
        return newSectionName;
    }

    public void setNewSectionName(String newSectionName) {
        this.newSectionName = newSectionName;
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
}
