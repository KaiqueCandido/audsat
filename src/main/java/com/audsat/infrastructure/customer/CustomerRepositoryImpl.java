package com.audsat.infrastructure.customer;

import com.audsat.domain.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerPersistence customerPersistence;

    public Customer getById(Long id) {
        Optional<Customer> optionalCustomer = customerPersistence.findById(id);
        return optionalCustomer.orElse(null);
    }

}
