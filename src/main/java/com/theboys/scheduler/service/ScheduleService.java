package com.theboys.scheduler.service;

import com.theboys.scheduler.dao.ScheduleRepository;
import com.theboys.scheduler.dto.ScheduleDto;
import com.theboys.scheduler.entity.Schedule;
import com.theboys.scheduler.exception.ScheduleNotFoundException;
import com.theboys.scheduler.mapper.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService implements IScheduleService{

    private final EntityDtoMapper entityDtoMapper;
    private final ScheduleRepository scheduleRepository;

    @Autowired
    public ScheduleService(EntityDtoMapper entityDtoMapper, ScheduleRepository scheduleRepository) {
        this.entityDtoMapper = entityDtoMapper;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public List<ScheduleDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return entityDtoMapper.mapScheduleToDtoList(schedules);
    }

    @Override
    public ScheduleDto findById(int theId) {
        Optional<Schedule> schedule = scheduleRepository.findById(theId);
        return schedule.map(entityDtoMapper::mapScheduleToDto)
                .orElseThrow(() -> new ScheduleNotFoundException("Schedule with ID " + theId + " not found" ));
    }

    @Override
    public ScheduleDto save(ScheduleDto theSchedule) {
        Schedule schedule = entityDtoMapper.mapScheduleDtoToEntity(theSchedule);
        schedule = scheduleRepository.save(schedule);
        return entityDtoMapper.mapScheduleToDto(schedule);
    }

    @Override
    public void deleteById(int theId) {
        if (!scheduleRepository.existsById(theId)){
            throw new ScheduleNotFoundException("Schedule with ID " + theId + "was not found.");
        }
        scheduleRepository.deleteById(theId);
    }
}
