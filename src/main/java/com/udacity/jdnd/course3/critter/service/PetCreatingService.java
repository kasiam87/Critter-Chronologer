package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.CustomerRepository;
import com.udacity.jdnd.course3.critter.persistence.Pet;
import com.udacity.jdnd.course3.critter.persistence.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.function.Function;

@Service
public class PetCreatingService implements Function<Pet, Pet> {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @Transactional
    public Pet apply(Pet pet) {
        return customerRepository.findById(pet.getOwnerId())
                .map(customer -> {
                    Pet savedPet = petRepository.save(pet);
                    customer.getPets().add(savedPet);
                    customerRepository.save(customer);
                    return savedPet;
                })
                .orElseThrow(() -> new CustomerNotFoundException(pet.getOwnerId()));
    }
}
