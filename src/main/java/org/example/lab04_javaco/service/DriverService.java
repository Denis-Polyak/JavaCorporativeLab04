package org.example.lab04_javaco.service;

import org.example.lab04_javaco.entity.Driver;
import org.example.lab04_javaco.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriverById(Long id) {
        return driverRepository.findById(id);
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }
}