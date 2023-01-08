package org.scavenger.warehouse.common.pojo.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
        "message"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseResponse {

    @JsonProperty(value = "message")
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
