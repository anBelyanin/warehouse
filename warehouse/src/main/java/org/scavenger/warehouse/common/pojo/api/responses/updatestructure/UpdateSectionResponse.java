package org.scavenger.warehouse.common.pojo.api.responses.updatestructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseResponse;

@JsonPropertyOrder({
        "newAreaName",
        "newName",
        "newNotes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdateSectionResponse extends WarehouseResponse {

    @JsonProperty(value = "newAreaName")
    private String newAreaName;

    @JsonProperty(value = "newName")
    private String newName;

    @JsonProperty(value = "newNotes")
    private String newNotes;

    public String getNewAreaName() {
        return newAreaName;
    }

    public void setNewAreaName(String newAreaName) {
        this.newAreaName = newAreaName;
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
