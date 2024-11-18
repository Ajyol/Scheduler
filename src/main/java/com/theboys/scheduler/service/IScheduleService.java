package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.ScheduleDto;
import com.theboys.scheduler.entity.Schedule;

import java.util.List;

public interface IScheduleService {
    List<ScheduleDto> findAll();
    ScheduleDto findById(int theId);
    ScheduleDto save(Schedule theSchedule);
    void deleteById(int theId);
}
