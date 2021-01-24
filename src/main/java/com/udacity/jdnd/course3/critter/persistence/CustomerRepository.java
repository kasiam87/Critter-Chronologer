package com.udacity.jdnd.course3.critter.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query("SELECT DISTINCT c FROM Customer c LEFT JOIN c.pets p WHERE p.id = :petId")
    Customer findByPetId(@Param("petId") long id);
}
