package com.audsat.application.insurance;

import com.audsat.domain.insurance.InsuranceDomain;
import com.audsat.domain.insurance.InsuranceService;
import com.audsat.infrastructure.car.Car;
import com.audsat.infrastructure.customer.Customer;
import com.audsat.infrastructure.driver.Driver;
import com.audsat.infrastructure.insurance.Insurance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InsuranceServiceImplTest {

    @Autowired
    InsuranceService insuranceService;

    @Test
    void createInsurance() {
        Insurance insuranceMock = Insurance.builder()
                .id(1L)
                .customer(Customer.builder()
                        .id(1L)
                        .name("Kaique")
                        .age(28)
                        .insuranceClaim(false)
                        .driver(Driver.builder()
                                .id(1L)
                                .document("12345")
                                .birthDate(LocalDate.now().withYear(2023).withMonth(03).withDayOfMonth(23))
                                .build())
                        .build())
                .updatedDate(null)
                .car(Car.builder()
                        .id(1L)
                        .model("Uno")
                        .manufacturer("Fiat")
                        .year("2000")
                        .fipeValue(15000F)
                        .insuranceClaim(true)
                        .build())
                .isActive(true)
                .budgetPercent(12F)
                .build();
        InsuranceDomain insuranceDomainMock = InsuranceDomain.builder()
                .customerId(1L)
                .carId(1L)
                .build();
        Insurance insurance = insuranceService.createInsurance(insuranceDomainMock);
        assertEquals(insurance.getCustomer(), insuranceMock.getCustomer());
        assertEquals(insurance.getCar(), insuranceMock.getCar());
        assertEquals(insurance.getUpdatedDate(), insuranceMock.getUpdatedDate());
        assertEquals(insurance.getIsActive(), insuranceMock.getIsActive());
        assertEquals(insurance.getBudgetPercent(), insuranceMock.getBudgetPercent());
    }

    @Test
    void getById() {
        Insurance insuranceMock = Insurance.builder()
                .id(1L)
                .customer(Customer.builder()
                        .id(1L)
                        .name("Kaique")
                        .age(28)
                        .insuranceClaim(false)
                        .driver(Driver.builder()
                                .id(1L)
                                .document("12345")
                                .birthDate(LocalDate.now().withYear(2023).withMonth(03).withDayOfMonth(23))
                                .build())
                        .build())
                .updatedDate(null)
                .car(Car.builder()
                        .id(1L)
                        .model("Uno")
                        .manufacturer("Fiat")
                        .year("2000")
                        .fipeValue(15000F)
                        .insuranceClaim(true)
                        .build())
                .isActive(true)
                .budgetPercent(12F)
                .build();
        Insurance insurance = insuranceService.getById(998L);
        assertEquals(insurance.getCustomer(), insuranceMock.getCustomer());
        assertEquals(insurance.getCar(), insuranceMock.getCar());
        assertEquals(insurance.getUpdatedDate(), insuranceMock.getUpdatedDate());
        assertEquals(insurance.getIsActive(), insuranceMock.getIsActive());
        assertEquals(insurance.getBudgetPercent(), insuranceMock.getBudgetPercent());
    }

    @Test
    void updateById() {
        Insurance insuranceMock = Insurance.builder()
                .id(1L)
                .customer(Customer.builder()
                        .id(2L)
                        .name("Oliveira")
                        .age(25)
                        .insuranceClaim(true)
                        .driver(Driver.builder()
                                .id(1L)
                                .document("12345")
                                .birthDate(LocalDate.now().withYear(2023).withMonth(03).withDayOfMonth(23))
                                .build())
                        .build())
                .updatedDate(null)
                .car(Car.builder()
                        .id(1L)
                        .model("Uno")
                        .manufacturer("Fiat")
                        .year("2000")
                        .fipeValue(15000F)
                        .insuranceClaim(true)
                        .build())
                .isActive(false)
                .budgetPercent(12F)
                .build();
        InsuranceDomain insuranceDomainMock = InsuranceDomain.builder()
                .customerId(2L)
                .carId(1L)
                .isActive(false)
                .build();
        Insurance insurance = insuranceService.updateById(999L, insuranceDomainMock);
        assertEquals(insurance.getCustomer(), insuranceMock.getCustomer());
        assertEquals(insurance.getCar(), insuranceMock.getCar());
        assertEquals(insurance.getIsActive(), insuranceMock.getIsActive());
        assertEquals(insurance.getBudgetPercent(), insuranceMock.getBudgetPercent());
    }

    @Test
    void deleteById() {
        Boolean aBoolean = insuranceService.deleteById(997L);
        assertEquals(aBoolean, true);
    }
}