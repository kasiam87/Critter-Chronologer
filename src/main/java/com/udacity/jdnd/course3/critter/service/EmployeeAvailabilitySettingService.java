package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Employee;
import com.udacity.jdnd.course3.critter.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.util.Set;

@Service
public class EmployeeAvailabilitySettingService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee invoke(Set<DayOfWeek> daysAvailable, long employeeId) {
        Employee employee = employeeRepository
                .findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        employee.setDaysAvailable(daysAvailable);
        return employee;
    }
}
