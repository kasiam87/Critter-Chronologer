package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Pet;
import com.udacity.jdnd.course3.critter.persistence.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AllPetsByOwnerFetchingService {

    @Autowired
    PetRepository petRepository;

    @Transactional
    public List<Pet> apply(Long ownerId) {
        return petRepository.findAllByOwnerId(ownerId);
    }
}
