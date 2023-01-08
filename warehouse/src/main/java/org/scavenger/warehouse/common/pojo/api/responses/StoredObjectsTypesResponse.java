package org.scavenger.warehouse.common.pojo.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.scavenger.warehouse.common.pojo.structure.StoredObjectType;

import java.util.List;

@JsonPropertyOrder({
        "storedObjectsTypes"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoredObjectsTypesResponse extends WarehouseResponse {

    @JsonProperty(value = "storedObjectsTypes", required = true)
    private List<StoredObjectType> storedObjectsTypes;

    public List<StoredObjectType> getStoredObjectsTypes() {
        return storedObjectsTypes;
    }

    public void setStoredObjectsTypes(List<StoredObjectType> storedObjectsTypes) {
        this.storedObjectsTypes = storedObjectsTypes;
    }
}
