package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Customer;
import com.udacity.jdnd.course3.critter.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
public class CustomerCreatingService implements Function<Customer, Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public Customer apply(Customer customer) {
        return customerRepository.save(customer);
    }
}
