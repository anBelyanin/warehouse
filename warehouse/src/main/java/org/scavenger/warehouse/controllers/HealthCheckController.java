package org.scavenger.warehouse.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health-check")
    public ResponseEntity getHealthCheck() {
        return ResponseEntity.ok().body("Service alive");
    }
}
