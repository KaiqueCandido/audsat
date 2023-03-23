package com.audsat.domain.car;

import com.audsat.domain.exception.notfound.CarNotFoundException;
import com.audsat.domain.exception.notfound.CustomerNotFoundException;
import com.audsat.infrastructure.car.Car;

public interface CarService {

    Car getCar(Long id) throws CarNotFoundException;;
}
