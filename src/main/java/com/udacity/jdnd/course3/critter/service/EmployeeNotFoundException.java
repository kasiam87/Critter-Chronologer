package com.udacity.jdnd.course3.critter.service;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(long id) {
        super("Could not find employee with id " + id);
    }
}
