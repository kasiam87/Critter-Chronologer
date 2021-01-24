package com.udacity.jdnd.course3.critter.presentation.schedule;

import com.udacity.jdnd.course3.critter.persistence.Schedule;
import com.udacity.jdnd.course3.critter.service.AllSchedulesFetchingService;
import com.udacity.jdnd.course3.critter.service.ScheduleCreatingService;
import com.udacity.jdnd.course3.critter.service.SchedulesByCustomerFetchingService;
import com.udacity.jdnd.course3.critter.service.SchedulesByEmployeeFetchingService;
import com.udacity.jdnd.course3.critter.service.SchedulesByPetFetchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Handles web requests related to Schedules.
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    ScheduleCreatingService scheduleCreatingService;

    @Autowired
    AllSchedulesFetchingService allSchedulesFetchingService;

    @Autowired
    SchedulesByEmployeeFetchingService schedulesByEmployeeFetchingService;

    @Autowired
    SchedulesByPetFetchingService schedulesByPetFetchingService;

    @Autowired
    SchedulesByCustomerFetchingService schedulesByCustomerFetchingService;

    @Autowired
    ScheduleConverter scheduleConverter;

    @PostMapping
    public ScheduleDTO createSchedule(@RequestBody ScheduleDTO scheduleDTO) {
        Schedule schedule = scheduleConverter.toDomain(scheduleDTO);
        Schedule newSchedule = scheduleCreatingService.invoke(schedule);
        return scheduleConverter.fromDomain(newSchedule);
    }

    @GetMapping
    public List<ScheduleDTO> getAllSchedules() {
        return allSchedulesFetchingService.invoke().stream().map(s -> scheduleConverter.fromDomain(s)).collect(Collectors.toList());
    }

    @GetMapping("/pet/{petId}")
    public List<ScheduleDTO> getScheduleForPet(@PathVariable long petId) {
        return schedulesByPetFetchingService.invoke(petId)
                .stream()
                .map(s -> scheduleConverter.fromDomain(s))
                .collect(Collectors.toList());
    }

    @GetMapping("/employee/{employeeId}")
    public List<ScheduleDTO> getScheduleForEmployee(@PathVariable long employeeId) {
        return schedulesByEmployeeFetchingService.invoke(employeeId)
                .stream()
                .map(s -> scheduleConverter.fromDomain(s))
                .collect(Collectors.toList());
    }

    @GetMapping("/customer/{customerId}")
    public List<ScheduleDTO> getScheduleForCustomer(@PathVariable long customerId) {
        return schedulesByCustomerFetchingService.invoke(customerId)
                .stream()
                .map(s -> scheduleConverter.fromDomain(s))
                .collect(Collectors.toList());
    }
}
