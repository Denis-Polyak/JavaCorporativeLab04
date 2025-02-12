package org.example.lab04_javaco.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicle_model", nullable = false, length = 255)
    private String vehicleModel;

    @Column(name = "registration_number", nullable = false, unique = true, length = 20)
    private String registrationNumber;

    @Column(name = "year_of_manufacture", nullable = false)
    private int yearOfManufacture;

    @Column(name = "vehicle_length", precision = 10, scale = 2)
    private BigDecimal vehicleLength;

    @Column(name = "vehicle_width", precision = 10, scale = 2)
    private BigDecimal vehicleWidth;

    @Column(name = "vehicle_height", precision = 10, scale = 2)
    private BigDecimal vehicleHeight;

    @Column(name = "color", length = 50)
    private String color;

    @Column(name = "weight_empty", precision = 10, scale = 2)
    private BigDecimal weightEmpty;

    @Column(name = "weight_loaded", precision = 10, scale = 2)
    private BigDecimal weightLoaded;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(name = "owner", length = 255)
    private String owner;

    @Enumerated(EnumType.STRING)
    @Column(name = "technical_condition", nullable = false)
    private TechnicalCondition technicalCondition;

    @ManyToOne
    @JoinColumn(name = "trailer_id")
    private Trailer trailer;
}