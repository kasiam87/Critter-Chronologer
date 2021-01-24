package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Pet;
import com.udacity.jdnd.course3.critter.persistence.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AllPetsFetchingService {

    @Autowired
    private PetRepository petRepository;

    @Transactional
    public List<Pet> invoke() {
        return (List<Pet>) petRepository.findAll();
    }
}
