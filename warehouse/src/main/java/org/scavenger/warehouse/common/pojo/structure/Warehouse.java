package org.scavenger.warehouse.common.pojo.structure;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "areas"
})
public class Warehouse {

    @JsonProperty(value = "areas")
    private List<Area> areas;

    public List<Area> getAreas() {
        return areas;
    }

    public void setAreas(List<Area> areas) {
        this.areas = areas;
    }
}
