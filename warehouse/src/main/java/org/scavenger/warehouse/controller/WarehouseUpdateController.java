package org.scavenger.warehouse.controller;

import org.core.exceptions.BusinessException;
import org.scavenger.warehouse.common.pojo.api.requests.updatestructure.*;
import org.scavenger.warehouse.common.pojo.api.responses.updatestructure.*;
import org.scavenger.warehouse.service.UpdateStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/structure/update")
public class WarehouseUpdateController {

    private final UpdateStructureService updateStructureService;

    @Autowired
    public WarehouseUpdateController(UpdateStructureService updateStructureService) {
        this.updateStructureService = updateStructureService;
    }

    @PostMapping(path = "/area", consumes = "application/json", produces = "application/json")
    public UpdateAreaResponse updateArea(@RequestBody UpdateAreaRequest request) {
        return updateStructureService.updateAreaByRequest(request);
    }

    @PostMapping(path = "/section", consumes = "application/json", produces = "application/json")
    public UpdateSectionResponse updateSection(@RequestBody UpdateSectionRequest request) {
        return updateStructureService.updateSectionByRequest(request);
    }

    @PostMapping(path = "/place", consumes = "application/json", produces = "application/json")
    public UpdatePlaceResponse updatePlace(@RequestBody UpdatePlaceRequest request) throws BusinessException {
        return updateStructureService.updatePlaceByRequest(request);
    }

    @PostMapping(path = "/stored-object", consumes = "application/json", produces = "application/json")
    public UpdateStoredObjectResponse updateStoredObject(@RequestBody UpdateStoredObjectRequest request) throws BusinessException {
        return updateStructureService.updateStoredObjectByRequest(request);
    }

    @PostMapping(path = "/stored-object-type", consumes = "application/json", produces = "application/json")
    public UpdateStoredObjectTypeResponse updateStoredObjectType(@RequestBody UpdateStoredObjectTypeRequest request) {
        return updateStructureService.updateStoredObjectTypeByRequest(request);
    }

}
