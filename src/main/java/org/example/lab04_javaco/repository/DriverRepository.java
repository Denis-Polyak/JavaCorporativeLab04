package org.example.lab04_javaco.repository;

import org.example.lab04_javaco.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Long> {
}