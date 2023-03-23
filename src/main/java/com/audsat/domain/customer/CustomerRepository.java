package com.audsat.domain.customer;

import com.audsat.infrastructure.customer.Customer;

public interface CustomerRepository {

    Customer getById(Long id);
}
