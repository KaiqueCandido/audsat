package com.audsat.application.customer;

import com.audsat.domain.customer.CustomerService;
import com.audsat.infrastructure.customer.Customer;
import com.audsat.infrastructure.driver.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceImplTest {

    @Autowired
    CustomerService customerService;

    @Test
    void getCustomer() {
        Customer customerMock = Customer.builder()
                .id(1L)
                .name("Kaique")
                .age(28)
                .insuranceClaim(false)
                .driver(Driver.builder()
                        .id(1L)
                        .document("12345")
                        .birthDate(LocalDate.now().withYear(2023).withMonth(03).withDayOfMonth(23))
                        .build())
                .build();
        Customer customer = customerService.getCustomer(1L);
        assertEquals(customer, customerMock);
    }
}