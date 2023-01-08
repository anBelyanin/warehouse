package org.scavenger.warehouse.common.pojo.api.requests.createstructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "areaName",
        "sectionName",
        "name",
        "notes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePlaceRequest {

    @JsonProperty(value = "areaName", required = true)
    private String areaName;

    @JsonProperty(value = "sectionName", required = true)
    private String sectionName;

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

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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
