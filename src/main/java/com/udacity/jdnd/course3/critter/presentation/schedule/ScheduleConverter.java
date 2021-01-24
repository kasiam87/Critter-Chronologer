package com.udacity.jdnd.course3.critter.presentation.schedule;

import com.udacity.jdnd.course3.critter.persistence.Employee;
import com.udacity.jdnd.course3.critter.persistence.Pet;
import com.udacity.jdnd.course3.critter.persistence.Schedule;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ScheduleConverter {

    public Schedule toDomain(ScheduleDTO scheduleDTO){
        Schedule schedule = new Schedule();
        schedule.setDate(scheduleDTO.getDate());
        schedule.setActivities(scheduleDTO.getActivities());

        if (scheduleDTO.getEmployeeIds() != null) {
            schedule.setEmployeeIds(scheduleDTO.getEmployeeIds().stream().map(id -> {
                Employee employee = new Employee();
                employee.setId(id);
                return employee;
            }).collect(Collectors.toList()));
        }

        if (scheduleDTO.getPetIds() != null) {
            schedule.setPetIds(scheduleDTO.getPetIds().stream().map(id -> {
                Pet pet = new Pet();
                pet.setId(id);
                return pet;
            }).collect(Collectors.toList()));
        }
        return schedule;
    }

    public ScheduleDTO fromDomain(Schedule schedule){
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setDate(schedule.getDate());
        scheduleDTO.setActivities(schedule.getActivities());
        scheduleDTO.setEmployeeIds(schedule.getEmployees()
                .stream()
                .map(Employee::getId)
                .collect(Collectors.toList()));

        scheduleDTO.setPetIds(schedule.getPets()
                .stream()
                .map(Pet::getId)
                .collect(Collectors.toList()));
        return scheduleDTO;
    }
}
