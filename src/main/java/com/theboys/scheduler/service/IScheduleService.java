package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.ScheduleDto;

import java.util.List;

public interface IScheduleService {
    List<ScheduleDto> findAll();
    ScheduleDto findById(int theId);
    ScheduleDto save(ScheduleDto theSchedule);
    void deleteById(int theId);
}
