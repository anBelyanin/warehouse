package org.scavenger.warehouse.controllers;

import org.scavenger.warehouse.common.pojo.api.requests.createstructure.*;
import org.scavenger.warehouse.common.pojo.api.responses.createstructure.*;
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

    @PostMapping(path = "/place", consumes = "application/json", produces = "application/json")
    public CreatePlaceResponse createPlace(@RequestBody CreatePlaceRequest request) {
        return createStructureService.createPlaceByRequest(request);
    }

    @PostMapping(path = "/stored-object-type", consumes = "application/json", produces = "application/json")
    public CreateStoredObjectTypeResponse createStoredObjectType(@RequestBody CreateStoredObjectTypeRequest request) {
        return createStructureService.createStoredObjectTypeByRequest(request);
    }

    @PostMapping(path = "/stored-object", consumes = "application/json", produces = "application/json")
    public CreateStoredObjectResponse createStoredObject(@RequestBody CreateStoredObjectRequest request) {
        return createStructureService.createStoredObjectByRequest(request);
    }

}
