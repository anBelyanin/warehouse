package org.scavenger.warehouse.common.pojo.structure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "sectionNumber",
        "places"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Section {

    @JsonProperty(value = "sectionNumber", required = true)
    private String sectionNumber;

    @JsonProperty(value = "places")
    private List<Place> places;

    public String getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
