package com.audsat.infrastructure.cardrivers;

import com.audsat.infrastructure.car.Car;
import com.audsat.infrastructure.driver.Driver;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "car_drivers")
@Data
public class CarDriver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @Column(name = "is_main_driver")
    private Boolean isMainDriver;
}
