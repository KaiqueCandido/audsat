package com.audsat.infrastructure.car;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String manufacturer;

    @Column(name = "year_car")
    private String year;

    @Column(name = "fipe_value")
    private Float fipeValue;

    @Column(name = "insurance_claim")
    private Boolean insuranceClaim;
}
