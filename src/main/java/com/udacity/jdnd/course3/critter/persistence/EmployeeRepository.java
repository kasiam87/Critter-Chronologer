package com.udacity.jdnd.course3.critter.persistence;

import com.udacity.jdnd.course3.critter.presentation.user.EmployeeSkill;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("SELECT DISTINCT e FROM Employee e" +
            " LEFT JOIN e.daysAvailable d" +
            " LEFT JOIN e.skills s" +
            " where d = :dayOfWeek AND" +
            " s IN :skills" +
            " group by e.id having count(e.id) = :skillsCount")
    List<Employee> findEmployeesByServiceAndTime(
            @Param("dayOfWeek") DayOfWeek day,
            @Param("skills") Set<EmployeeSkill> skill,
            @Param("skillsCount") Long skillsCount
    );
}
