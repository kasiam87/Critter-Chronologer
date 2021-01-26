package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Pet;
import com.udacity.jdnd.course3.critter.persistence.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetFetchingService {

    @Autowired
    PetRepository petRepository;

    @Transactional
    public Pet invoke(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
    }
}
