package com.udacity.jdnd.course3.critter.service;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(long id) {
        super("Could not find customer with id " + id);
    }
}
