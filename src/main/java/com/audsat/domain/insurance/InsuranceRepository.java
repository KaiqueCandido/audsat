package com.audsat.domain.insurance;

import com.audsat.infrastructure.insurance.Insurance;

public interface InsuranceRepository {

    Insurance getById(Long id);

    Insurance save(Insurance insurance);

    void deleteById(Long insuranceId);
}
