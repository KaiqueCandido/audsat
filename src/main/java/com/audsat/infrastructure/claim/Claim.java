package com.audsat.infrastructure.claim;

import com.audsat.infrastructure.car.Car;
import com.audsat.infrastructure.driver.Driver;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "claims")
@Data
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(name = "event_date")
    private LocalDate eventDate;
}

