package org.scavenger.warehouse.controllers;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.scavenger.warehouse.common.pojo.api.requests.WarehouseLoadRequest;
import org.scavenger.warehouse.common.pojo.api.responses.WarehouseLoadResponse;
import org.scavenger.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping(path = "/warehouse", consumes = "application/json", produces = "application/json")
    public WarehouseLoadResponse loadWarehouse(WarehouseLoadRequest warehouseLoadRequest) {
        warehouseService.validateRequest(warehouseLoadRequest);
        return warehouseService.loadWarehouse(warehouseLoadRequest);
    }
}
