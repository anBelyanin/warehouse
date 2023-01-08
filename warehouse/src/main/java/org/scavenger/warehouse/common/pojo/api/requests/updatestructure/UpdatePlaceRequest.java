package org.scavenger.warehouse.common.pojo.api.requests.updatestructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "areaName",
        "sectionName",
        "name",
        "newAreaName",
        "newSectionName",
        "newName",
        "newNotes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class UpdatePlaceRequest {

    @JsonProperty(value = "areaName", required = true)
    private String areaName;

    @JsonProperty(value = "sectionName", required = true)
    private String sectionName;

    @JsonProperty(value = "name", required = true)
    private String name;

    @JsonProperty(value = "newAreaName")
    private String newAreaName;

    @JsonProperty(value = "newSectionName")
    private String newSectionName;

    @JsonProperty(value = "newName")
    private String newName;

    @JsonProperty(value = "newNotes")
    private String newNotes;

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
