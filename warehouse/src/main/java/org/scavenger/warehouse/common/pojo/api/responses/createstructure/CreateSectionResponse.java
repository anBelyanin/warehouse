package org.scavenger.warehouse.common.pojo.api.responses.createstructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseResponse;

@JsonPropertyOrder({
        "areaName",
        "name",
        "notes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSectionResponse extends WarehouseResponse {

    @JsonProperty(value = "areaName", required = true)
    private String areaName;

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "notes")
    private String notes;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

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
