package com.udacity.jdnd.course3.critter.presentation.user;

import com.udacity.jdnd.course3.critter.persistence.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeConverter {

    public Employee toDomain(EmployeeDTO employeeDTO){
        Employee customer = new Employee();
        customer.setId(employeeDTO.getId());
        customer.setName(employeeDTO.getName());
        customer.setSkills(employeeDTO.getSkills());
        customer.setDaysAvailable(employeeDTO.getDaysAvailable());
        return customer;
    }

    public EmployeeDTO fromDomain(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setName(employee.getName());
        employeeDTO.setSkills(employee.getSkills());
        employeeDTO.setDaysAvailable(employee.getDaysAvailable());
        return employeeDTO;
    }
}
