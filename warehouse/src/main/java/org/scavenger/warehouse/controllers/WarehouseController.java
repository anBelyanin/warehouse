package org.scavenger.warehouse.controllers;

import org.scavenger.warehouse.common.pojo.api.WarehouseRequest;
import org.scavenger.warehouse.common.pojo.api.WarehouseResponse;
import org.scavenger.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WarehouseController {

    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @PostMapping("/warehouse")
    public WarehouseResponse loadWarehouse(WarehouseRequest warehouseRequest) {
        warehouseService.validateRequest(warehouseRequest);
        return warehouseService.loadWarehouse(warehouseRequest);
    }
}
