package com.udacity.jdnd.course3.critter.service;

import com.udacity.jdnd.course3.critter.persistence.Schedule;
import com.udacity.jdnd.course3.critter.persistence.ScheduleRepository;
import com.udacity.jdnd.course3.critter.presentation.schedule.ScheduleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleCreatingService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleConverter scheduleConverter;

    @Transactional
    public Schedule invoke(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }
}
