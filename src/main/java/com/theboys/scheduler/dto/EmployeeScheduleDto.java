package com.theboys.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeScheduleDto {
    @Getter @Setter
    private int id;
    @Getter @Setter
    private int employeeId;
    @Getter @Setter
    private LocalDateTime shiftStart;
    @Getter @Setter
    private LocalDateTime shiftEnd;
    @Getter @Setter
    private String dayOfWeek;
}
