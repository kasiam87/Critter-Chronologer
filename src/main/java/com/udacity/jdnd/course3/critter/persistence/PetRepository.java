package com.udacity.jdnd.course3.critter.persistence;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
