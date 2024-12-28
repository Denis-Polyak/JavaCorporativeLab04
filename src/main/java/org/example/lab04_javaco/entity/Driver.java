package org.example.lab04_javaco.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "passport_series", length = 10)
    private String passportSeries;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "passport_number", length = 10)
    private String passportNumber;

    @Column(name = "issued_by", length = 255)
    private String issuedBy;

    @Column(name = "issued_date")
    private LocalDate issuedDate;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "driver_license_number", length = 20)
    private String driverLicenseNumber;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "patronymic", length = 50)
    private String patronymic;
}