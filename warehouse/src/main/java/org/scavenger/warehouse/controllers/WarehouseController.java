package org.scavenger.warehouse.controllers;

import org.scavenger.warehouse.common.pojo.api.responses.StoredObjectsTypesResponse;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseLoadResponse;
import org.scavenger.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping(path = "/", produces = "application/json")
    public WarehouseLoadResponse getWarehouse() {
        return warehouseService.getWarehouse();
    }

    @GetMapping(path = "/types", produces = "application/json")
    public StoredObjectsTypesResponse getStoredObjectsTypes() {
        return warehouseService.getStoredObjectsTypes();
    }
}
