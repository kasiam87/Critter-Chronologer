package com.udacity.jdnd.course3.critter.service;

public class PetNotFoundException extends RuntimeException {

    public PetNotFoundException(long id) {
        super("Could not find pet with id " + id);
    }
}
