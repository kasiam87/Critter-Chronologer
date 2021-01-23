package com.udacity.jdnd.course3.critter.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepository extends CrudRepository<Pet, Long> {

    List<Pet> findAllByOwnerId(Long ownerId);
}
