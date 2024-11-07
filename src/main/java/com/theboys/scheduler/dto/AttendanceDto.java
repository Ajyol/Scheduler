package com.theboys.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {
    @Getter
    @Setter
    private int attendanceId;

    private EmployeeDto employee;

    private ScheduleDto schedule;

    @Getter
    @Setter
    private LocalTime clockIn;

    @Getter
    @Setter
    private LocalTime clockOut;

    @Getter
    @Setter
    private AttendanceStatus status;

    public enum AttendanceStatus {
        PRESENT, ABSENT, LATE, EXCUSED
    }
}
