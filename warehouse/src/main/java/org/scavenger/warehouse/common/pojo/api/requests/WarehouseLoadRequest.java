package org.scavenger.warehouse.common.pojo.api.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "warehouse"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseLoadRequest {

    @JsonProperty(value = "warehouse", required = true)
    private String warehouse;

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }
}
