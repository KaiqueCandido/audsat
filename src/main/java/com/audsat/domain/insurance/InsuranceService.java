package com.audsat.domain.insurance;

import com.audsat.domain.exception.notfound.InsuranceNotFoundException;
import com.audsat.infrastructure.insurance.Insurance;

public interface InsuranceService {
    Insurance createInsurance(InsuranceDomain insuranceDomain);

    Insurance getById(Long id) throws InsuranceNotFoundException;

    Insurance updateById(Long insuranceId, InsuranceDomain insuranceDomain);

    Boolean deleteById(Long id);
}

