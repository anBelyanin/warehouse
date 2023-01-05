package org.scavenger.warehouse.common.pojo.structure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "placeNumber",
        "storedObjects"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place {

    @JsonProperty(value = "placeNumber", required = true)
    private String placeNumber;

    @JsonProperty(value = "storedObjects")
    private List<StoredObject> storedObjects;

    public String getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(String placeNumber) {
        this.placeNumber = placeNumber;
    }

    public List<StoredObject> getStoredObjects() {
        return storedObjects;
    }

    public void setStoredObjects(List<StoredObject> storedObjects) {
        this.storedObjects = storedObjects;
    }
}
