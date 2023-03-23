package com.audsat.infrastructure.insurance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePersistence extends JpaRepository<Insurance, Long> {

}
