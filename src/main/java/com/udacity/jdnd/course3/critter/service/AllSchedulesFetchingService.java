package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Schedule;
import com.udacity.jdnd.course3.critter.persistence.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AllSchedulesFetchingService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Transactional
    public List<Schedule> invoke() {
        return (List<Schedule>) scheduleRepository.findAll();
    }
}
