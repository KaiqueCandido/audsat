package com.audsat.domain.customer;

import com.audsat.domain.exception.notfound.CustomerNotFoundException;
import com.audsat.infrastructure.customer.Customer;

public interface CustomerService {
    Customer getCustomer(Long id) throws CustomerNotFoundException;
}
