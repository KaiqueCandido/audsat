package com.audsat.infrastructure.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerPersistence extends JpaRepository<Customer, Long> {

}
