package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Customer;
import com.udacity.jdnd.course3.critter.persistence.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AllCustomerFetchingService {

    @Autowired
    private CustomerRepository customerRepository;

    @Transactional
    public List<Customer> invoke() {
        return (List<Customer>) customerRepository.findAll();
    }
}
