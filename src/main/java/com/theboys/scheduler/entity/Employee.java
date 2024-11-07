package com.theboys.scheduler.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "employees")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @NotBlank(message = "First name is mandatory")
    @Size(max = 100, message = "First name can be up to 100 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    @Size(max = 100, message = "Last name can be up to 100 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    @Size(max = 100, message = "Email can be up to 100 characters")
    @Column(unique = true, nullable = false)
    private String email;

    @Size(max = 20, message = "Phone number can be up to 20 characters")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Size(max = 150, message = "Address can be up to 150 characters")
    @Column(name = "address")
    private String address;

    @NotNull(message = "Hire date is mandatory")
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    @NotNull(message = "Position ID is mandatory")
    @Column(name = "position_id", nullable = false)
    private int positionId;

    @NotNull(message = "Department ID is mandatory")
    @Column(name = "department_id", nullable = false)
    private int departmentId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private EmployeeStatus status;

    // Enum to represent status
    public enum EmployeeStatus {
        ACTIVE, INACTIVE, TERMINATED
    }
}
