package com.audsat.infrastructure.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPersistence extends JpaRepository<Car, Long> {

}
