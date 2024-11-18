package com.theboys.scheduler.controller;

import com.theboys.scheduler.dto.AttendanceDto;
import com.theboys.scheduler.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AttendanceController
{
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/attendaces")
    public List<AttendanceDto> findAllAttendances() { return attendanceService.findAll(); }

    @GetMapping("/attendances/{attendanceId}")
    public ResponseEntity<AttendanceDto> getAttendanceById(@PathVariable int attendanceId) {
        AttendanceDto attendanceDto = attendanceService.findById(attendanceId);
        return new ResponseEntity<>(attendanceDto, HttpStatus.OK);
    }

    @PostMapping("/attendances")
    public ResponseEntity<AttendanceDto> addAttendance(@RequestBody AttendanceDto attendanceDto) {
        AttendanceDto savedAttendance = attendanceService.save(attendanceDto);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }

    @PutMapping("/attendances")
    public ResponseEntity<AttendanceDto> updateAttendance(@RequestBody AttendanceDto attendanceDto) {
        AttendanceDto updatedEmployee = attendanceService.save(attendanceDto);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/attendances/{attendanceId}")
    public ResponseEntity<String> deleteAttendance(@PathVariable int attendanceId) {
        attendanceService.deleteById(attendanceId);
        return new ResponseEntity<>("Attendance deleted successfully", HttpStatus.OK);
    }
}
