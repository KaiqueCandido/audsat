package com.audsat.application.car;

import com.audsat.domain.car.CarService;
import com.audsat.infrastructure.car.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarServiceImplTest {

    @Autowired
    CarService carService;

    @Test
    void testGetCar() {
        Car carMock = Car.builder()
                .id(1L)
                .model("Uno")
                .manufacturer("Fiat")
                .year("2000")
                .fipeValue(15000F)
                .insuranceClaim(true)
                .build();
        Car car = carService.getCar(1L);
        assertEquals(car, carMock);
    }
}