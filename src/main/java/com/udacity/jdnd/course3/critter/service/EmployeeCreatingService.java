package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Employee;
import com.udacity.jdnd.course3.critter.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
public class EmployeeCreatingService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee invoke(Employee employee) {
        return employeeRepository.save(employee);
    }
}
