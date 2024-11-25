package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.AttendanceDto;

import java.util.List;

public interface IAttendanceService {
    List<AttendanceDto> findAll();
    AttendanceDto findById(int theId);
    AttendanceDto save(AttendanceDto theAttendance);
    void deleteById(int theId);
}
