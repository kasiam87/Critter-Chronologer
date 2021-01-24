package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Schedule;
import com.udacity.jdnd.course3.critter.persistence.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class SchedulesByCustomerFetchingService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Transactional
    public Set<Schedule> invoke(Long petId) {
        return scheduleRepository.findAllByCustomerId(petId);
    }
}
