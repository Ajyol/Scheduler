package com.theboys.scheduler.controller;

import com.theboys.scheduler.dto.ScheduleDto;
import com.theboys.scheduler.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedules")
    public List<ScheduleDto> findAllSchedules() { return scheduleService.findAll(); }

    @GetMapping("/schedules/{scheduleId}")
    public ResponseEntity<ScheduleDto> findScheduleById(@PathVariable int scheduleId) {
        ScheduleDto scheduleDto = scheduleService.findById(scheduleId);
        return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
    }

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleDto> addSchedule(@RequestBody ScheduleDto scheduleDto) {
        ScheduleDto savedSchedule = scheduleService.save(scheduleDto);
        return new ResponseEntity<>(savedSchedule, HttpStatus.CREATED);
    }

    @PutMapping("/schedules")
    public ResponseEntity<ScheduleDto> updateSchedule(@RequestBody ScheduleDto scheduleDto) {
        ScheduleDto updatedSchedule = scheduleService.save(scheduleDto);
        return new ResponseEntity<>(updatedSchedule, HttpStatus.OK);
    }

    @DeleteMapping("/schedules/{scheduleId}")
    public ResponseEntity<String> deleteSchedule(@PathVariable int scheduleId) {
        scheduleService.deleteById(scheduleId);
        return new ResponseEntity<>("Schedule deleted successfully", HttpStatus.OK);

    }
}
