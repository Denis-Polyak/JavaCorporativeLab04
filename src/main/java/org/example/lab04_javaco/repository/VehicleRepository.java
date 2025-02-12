package org.example.lab04_javaco.repository;

import org.example.lab04_javaco.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Vehicle findByRegistrationNumber(String registrationNumber);

    List<Vehicle> findByColor(String color);

    List<Vehicle> findByYearOfManufacture(int year);
}

