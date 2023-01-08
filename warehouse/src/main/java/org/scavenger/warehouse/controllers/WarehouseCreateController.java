package org.scavenger.warehouse.controllers;

import org.scavenger.warehouse.common.pojo.api.requests.createstructure.CreateAreaRequest;
import org.scavenger.warehouse.common.pojo.api.requests.createstructure.CreateSectionRequest;
import org.scavenger.warehouse.common.pojo.api.responses.createstructure.CreateAreaResponse;
import org.scavenger.warehouse.common.pojo.api.responses.createstructure.CreateSectionResponse;
import org.scavenger.warehouse.service.CreateStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/structure/create")
public class WarehouseCreateController {

    private final CreateStructureService createStructureService;

    @Autowired
    public WarehouseCreateController(CreateStructureService createStructureService) {
        this.createStructureService = createStructureService;
    }

    @PostMapping(path = "/area", consumes = "application/json", produces = "application/json")
    public CreateAreaResponse createArea(@RequestBody CreateAreaRequest request) {
        return createStructureService.createAreaByRequest(request);
    }

    @PostMapping(path = "/section", consumes = "application/json", produces = "application/json")
    public CreateSectionResponse createSection(@RequestBody CreateSectionRequest request) {
        return createStructureService.createSectionByRequest(request);
    }
}
