package com.audsat.infrastructure.car;

import com.audsat.domain.car.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {

    private final CarPersistence carPersistence;

    public Car getById(Long id) {
        Optional<Car> optionalCar = carPersistence.findById(id);
        return optionalCar.orElse(null);
    }

}
