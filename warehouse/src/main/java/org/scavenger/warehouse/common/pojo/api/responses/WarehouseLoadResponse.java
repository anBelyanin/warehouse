package org.scavenger.warehouse.common.pojo.api.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.scavenger.warehouse.common.pojo.structure.Area;

import java.util.List;

@JsonPropertyOrder({
        "areas"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseLoadResponse {

    @JsonProperty(value = "areas")
    private List<Area> areas;

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
