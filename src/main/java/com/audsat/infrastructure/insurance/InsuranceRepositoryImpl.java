package com.audsat.infrastructure.insurance;

import com.audsat.domain.insurance.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class InsuranceRepositoryImpl implements InsuranceRepository {

    private final InsurancePersistence insurancePersistence;

    public Insurance getById(Long id) {
        Optional<Insurance> optionalInsurance = insurancePersistence.findById(id);
        return optionalInsurance.orElse(null);
    }

    public Insurance save(Insurance insurance) {
        return insurancePersistence.save(insurance);
    }

    @Override
    public void deleteById(Long insuranceId) {
        insurancePersistence.deleteById(insuranceId);
    }

}
