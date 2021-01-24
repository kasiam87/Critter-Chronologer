package com.udacity.jdnd.course3.critter.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

    @Query("SELECT s FROM Schedule s LEFT JOIN s.employees e WHERE e.id = :employeeId")
    Set<Schedule> findAllByEmployeeId(@Param("employeeId") long employeeId);

    @Query("SELECT s FROM Schedule s LEFT JOIN s.pets p WHERE p.id = :petId")
    Set<Schedule> findAllByPetId(@Param("petId") long petId);

    @Query("SELECT s FROM Schedule s LEFT JOIN s.pets p WHERE p.ownerId = :customerId")
    Set<Schedule> findAllByCustomerId(@Param("customerId") long customerId);
}
