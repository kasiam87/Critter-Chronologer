package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Pet;
import com.udacity.jdnd.course3.critter.persistence.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PetFetchingService {

    @Autowired
    PetRepository petRepository;

    @Transactional
    public Optional<Pet> invoke(Long id) {
        return petRepository.findById(id);
    }
}
