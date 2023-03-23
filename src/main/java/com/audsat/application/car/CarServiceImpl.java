package com.audsat.application.car;

import com.audsat.domain.car.CarRepository;
import com.audsat.domain.car.CarService;
import com.audsat.domain.exception.notfound.CarNotFoundException;
import com.audsat.infrastructure.car.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public Car getCar(Long id) throws CarNotFoundException {
        Car car = carRepository.getById(id);
        if (car == null) throw new CarNotFoundException("Car not found with id:" + id);
        return car;
    }
}
