package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Employee;
import com.udacity.jdnd.course3.critter.persistence.EmployeeRepository;
import com.udacity.jdnd.course3.critter.presentation.user.EmployeeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeForServiceFetchingService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public List<Employee> invoke(LocalDate date, Set<EmployeeSkill> skills) {
        return employeeRepository.findEmployeesByServiceAndTime(date.getDayOfWeek(), skills, (long) skills.size());
    }
}
