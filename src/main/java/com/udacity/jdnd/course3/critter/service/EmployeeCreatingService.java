package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Employee;
import com.udacity.jdnd.course3.critter.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
public class EmployeeCreatingService implements Function<Employee, Employee> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee apply(Employee employee) {
        return employeeRepository.save(employee);
    }
}
