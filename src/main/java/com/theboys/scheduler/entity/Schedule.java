package com.theboys.scheduler.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "schedules")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private int scheduleId;

    @NotNull(message = "Employee ID is mandatory")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @NotNull(message = "Shift date is mandatory")
    @Column(name = "shift_date", nullable = false)
    private LocalDate shiftDate;

    @NotNull(message = "Shift start time is mandatory")
    @Column(name = "shift_start", nullable = false)
    private LocalTime shiftStart;

    @NotNull(message = "Shift end time is mandatory")
    @Column(name = "shift_end", nullable = false)
    private LocalTime shiftEnd;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ScheduleStatus status;

    public enum ScheduleStatus {
        SCHEDULED, COMPLETED, CANCELLED
    }
}
