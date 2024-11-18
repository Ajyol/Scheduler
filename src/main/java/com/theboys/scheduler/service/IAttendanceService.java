package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.AttendanceDto;
import com.theboys.scheduler.entity.Attendance;

import java.util.List;

public interface IAttendanceService {
    List<AttendanceDto> findAll();
    AttendanceDto findById(int theId);
    AttendanceDto save(Attendance theAttendance);
    void deleteById(int theId);
}
