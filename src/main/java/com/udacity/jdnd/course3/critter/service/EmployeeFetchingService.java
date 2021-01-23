package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Employee;
import com.udacity.jdnd.course3.critter.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeFetchingService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Optional<Employee> apply(Long id) {
        return employeeRepository.findById(id);
    }
}
