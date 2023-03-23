package com.audsat.application.insurance;

import com.audsat.domain.car.CarService;
import com.audsat.domain.customer.CustomerService;
import com.audsat.domain.exception.business.InsuranceBusinessException;
import com.audsat.domain.exception.notfound.CarNotFoundException;
import com.audsat.domain.exception.notfound.CustomerNotFoundException;
import com.audsat.domain.exception.notfound.InsuranceNotFoundException;
import com.audsat.domain.insurance.InsuranceDomain;
import com.audsat.domain.insurance.InsuranceRepository;
import com.audsat.domain.insurance.InsuranceService;
import com.audsat.infrastructure.car.Car;
import com.audsat.infrastructure.customer.Customer;
import com.audsat.infrastructure.insurance.Insurance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final CustomerService customerService;
    private final CarService carService;
    private final InsuranceRepository insuranceRepository;

    @Override
    public Insurance createInsurance(InsuranceDomain insuranceDomain) {
        Customer customer = getCustomer(insuranceDomain);
        Car car = getCar(insuranceDomain);

        Insurance insurance = Insurance
                .builder()
                .customer(customer)
                .creationDate(LocalDateTime.now())
                .car(car)
                .isActive(true)
                .build();
        return insuranceRepository.save(insurance);
    }

    @Override
    public Insurance getById(Long id) {
        Insurance insurance = insuranceRepository.getById(id);
        if (insurance == null) throw new InsuranceNotFoundException("Insurance not found with id:" + id);
        return insurance;
    }

    @Override
    public Insurance updateById(Long insuranceId, InsuranceDomain insuranceDomain) {
        Insurance insurance = this.getById(insuranceId);

        Customer customer = getCustomer(insuranceDomain);
        Car car = getCar(insuranceDomain);

        insurance.setCustomer(customer);
        insurance.setCar(car);
        insurance.setIsActive(insuranceDomain.getIsActive());
        insurance.setUpdatedDate(LocalDateTime.now());

        return insuranceRepository.save(insurance);
    }

    @Override
    public Boolean deleteById(Long id) {
        this.getById(id);
        insuranceRepository.deleteById(id);
        return true;
    }

    private Car getCar(InsuranceDomain insuranceDomain) {
        try {
            return carService.getCar(insuranceDomain.getCarId());
        } catch (CarNotFoundException e) {
            throw new InsuranceBusinessException("Failed to create insurance: " + e.getMessage());
        }
    }

    private Customer getCustomer(InsuranceDomain insuranceDomain) {
        try {
            return customerService.getCustomer(insuranceDomain.getCustomerId());
        } catch (CustomerNotFoundException e) {
            throw new InsuranceBusinessException("Failed to create insurance: " + e.getMessage());
        }
    }
}
