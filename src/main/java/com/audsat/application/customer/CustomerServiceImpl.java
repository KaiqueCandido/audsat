package com.audsat.application.customer;

import com.audsat.domain.customer.CustomerService;
import com.audsat.domain.exception.notfound.CustomerNotFoundException;
import com.audsat.infrastructure.customer.Customer;
import com.audsat.infrastructure.customer.CustomerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepositoryImpl customerRepository;

    @Override
    public Customer getCustomer(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.getById(id);
        if (customer == null) throw new CustomerNotFoundException("Customer not found with id:" + id);
        return customer;
    }
}
