package com.theboys.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.theboys.scheduler.entity.Employee;
import com.theboys.scheduler.entity.Schedule;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {
    @Getter @Setter
    private int scheduleId;

    @Getter @Setter
    private Employee employee;

    @Getter @Setter
    private LocalDate shiftDate;

    @Getter @Setter
    private LocalTime shiftStart;

    @Getter @Setter
    private LocalTime shiftEnd;

    @Getter @Setter
    private Schedule.ScheduleStatus status;

    public enum ScheduleStatus {
        SCHEDULED, COMPLETED, CANCELLED
    }
}
