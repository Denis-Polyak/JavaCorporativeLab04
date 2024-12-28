package org.example.lab04_javaco.controller;

import org.example.lab04_javaco.entity.Driver;
import org.example.lab04_javaco.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drivers")
public class DriverController {
    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        return driverService.getDriverById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driverService.saveDriver(driver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable Long id, @RequestBody Driver driver) {
        return driverService.getDriverById(id)
                .map(existingDriver -> {
                    driver.setId(id);
                    return ResponseEntity.ok(driverService.saveDriver(driver));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}