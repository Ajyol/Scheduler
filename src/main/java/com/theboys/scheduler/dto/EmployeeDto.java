package com.theboys.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private LocalDate hireDate;
    private Long positionId;
    private Long departmentId;
    private EmployeeStatus status;
    private String positionName;
    private String positionDescription;
    private String departmentName;
    private String departmentDescription;

    public enum EmployeeStatus {
        ACTIVE, INACTIVE, TERMINATED
    }
}
