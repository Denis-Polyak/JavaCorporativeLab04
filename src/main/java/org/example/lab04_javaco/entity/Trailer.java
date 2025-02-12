package org.example.lab04_javaco.entity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "trailers")
public class Trailer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "trailer_number", nullable = false, length = 255)
    private String trailerNumber;

    @Column(name = "trailer_length", precision = 10, scale = 2)
    private BigDecimal trailerLength;

    @Column(name = "trailer_width", precision = 10, scale = 2)
    private BigDecimal trailerWidth;

    @Column(name = "trailer_height", precision = 10, scale = 2)
    private BigDecimal trailerHeight;

    @Column(name = "trailer_weight_empty", precision = 10, scale = 2)
    private BigDecimal trailerWeightEmpty;

    @Column(name = "trailer_weight_loaded", precision = 10, scale = 2)
    private BigDecimal trailerWeightLoaded;
}