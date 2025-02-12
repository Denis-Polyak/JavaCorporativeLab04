package org.example.lab04_javaco.controller;

import org.example.lab04_javaco.entity.Vehicle;
import org.example.lab04_javaco.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.lab04_javaco.factory.VehicleUpdateFactory;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleUpdateFactory vehicleUpdateFactory;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleUpdateFactory vehicleUpdateFactory) {
        this.vehicleService = vehicleService;
        this.vehicleUpdateFactory = vehicleUpdateFactory;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        return vehicle.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        Vehicle savedVehicle = vehicleService.saveVehicle(vehicle);
        return ResponseEntity.ok(savedVehicle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicleDetails) {
        Optional<Vehicle> existingVehicle = vehicleService.getVehicleById(id);

        if (existingVehicle.isPresent()) {
            Vehicle vehicle = existingVehicle.get();
            vehicleUpdateFactory.updateVehicle(vehicle, vehicleDetails); // Використання фабрики
            Vehicle updatedVehicle = vehicleService.saveVehicle(vehicle);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);

        if (vehicle.isPresent()) {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/registration/{registrationNumber}")
    public ResponseEntity<Vehicle> getVehicleByRegistrationNumber(@PathVariable String registrationNumber) {
        Vehicle vehicle = vehicleService.getVehicleByRegistrationNumber(registrationNumber);
        return vehicle != null ? ResponseEntity.ok(vehicle) : ResponseEntity.notFound().build();
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<List<Vehicle>> getVehiclesByColor(@PathVariable String color) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByColor(color);
        return ResponseEntity.ok(vehicles);
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Vehicle>> getVehiclesByYear(@PathVariable int year) {
        List<Vehicle> vehicles = vehicleService.getVehiclesByYearOfManufacture(year);
        return ResponseEntity.ok(vehicles);
    }
}

