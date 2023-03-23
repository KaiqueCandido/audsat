package com.audsat.domain.car;

import com.audsat.infrastructure.car.Car;

public interface CarRepository {

    Car getById(Long id);
}
