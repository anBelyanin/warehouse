package org.scavenger.warehouse.common.pojo.structure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({
        "areaNumber",
        "sections"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Area {

    @JsonProperty(value = "areaNumber", required = true)
    private String areaNumber;

    @JsonProperty(value = "sections")
    private List<Section> sections;

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }
}
