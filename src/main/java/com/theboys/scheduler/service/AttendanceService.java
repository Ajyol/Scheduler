package com.theboys.scheduler.service;

import com.theboys.scheduler.dao.AttendanceRepository;
import com.theboys.scheduler.dto.AttendanceDto;
import com.theboys.scheduler.entity.Attendance;
import com.theboys.scheduler.exception.AttendanceNotFoundException;
import com.theboys.scheduler.mapper.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService implements IAttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository, EntityDtoMapper entityDtoMapper) {
        this.attendanceRepository = attendanceRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<AttendanceDto> findAll() {
        List<Attendance> attendances = attendanceRepository.findAll();
        return entityDtoMapper.mapAttendanceToDtoList(attendances);
    }

    @Override
    public AttendanceDto findById(int theId) {
        Attendance attendance = attendanceRepository.findById(theId)
                .orElseThrow(() -> new AttendanceNotFoundException("Attendance not found for ID: " + theId));
        return entityDtoMapper.mapAttendanceToDto(attendance);
    }

    @Override
    public AttendanceDto save(AttendanceDto attendanceDto) {
        Attendance attendance = entityDtoMapper.mapAttendanceDtoToEntity(attendanceDto);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return entityDtoMapper.mapAttendanceToDto(savedAttendance);    }


    @Override
    public void deleteById(int theId) {
        if (!attendanceRepository.existsById(theId)) {
            throw new AttendanceNotFoundException("Attendance not found for ID: " + theId);
        }
        attendanceRepository.deleteById(theId);
    }
}
