package com.theboys.scheduler.mapper;

import com.theboys.scheduler.dto.*;
import com.theboys.scheduler.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityDtoMapper {

    // Employee entity to Employee DTO (basic information)
    public EmployeeDto mapEmployeeToDtoBasic(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setEmployeeId((long) employee.getEmployeeId());
        employeeDto.setFirstName(employee.getFirstName());
        employeeDto.setLastName(employee.getLastName());
        employeeDto.setEmail(employee.getEmail());
        employeeDto.setPhoneNumber(employee.getPhoneNumber());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setHireDate(employee.getHireDate());
        employeeDto.setStatus(EmployeeDto.EmployeeStatus.valueOf(employee.getStatus().name()));

        // Set Position and Department related data
        if (employee.getPosition() != null) {
            employeeDto.setPositionId((long) employee.getPosition().getPositionId());
        }
        if (employee.getDepartment() != null) {
            employeeDto.setDepartmentId((long) employee.getDepartment().getDepartmentId());
        }

        return employeeDto;
    }

    // Employee entity to Employee DTO (with Position and Department details)
    public EmployeeDto mapEmployeeToDtoWithPositionAndDepartment(Employee employee) {
        EmployeeDto employeeDto = mapEmployeeToDtoBasic(employee);

        // Add Position details if available
        if (employee.getPosition() != null) {
            employeeDto.setPositionName(employee.getPosition().getPositionTitle());
        }

        // Add Department details if available
        if (employee.getDepartment() != null) {
            employeeDto.setDepartmentName(employee.getDepartment().getDepartmentName());
        }

        return employeeDto;
    }

    // Position entity to Position DTO
    public PositionDto mapPositionToDto(Position position) {
        PositionDto positionDto = new PositionDto();
        positionDto.setPositionId(position.getPositionId());
        positionDto.setPositionTitle(position.getPositionTitle());
        return positionDto;
    }

    // Department entity to Department DTO
    public DepartmentDto mapDepartmentToDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentId(department.getDepartmentId());
        departmentDto.setDepartmentName(department.getDepartmentName());
        return departmentDto;
    }

    // EmployeeSchedule entity to EmployeeSchedule DTO
    public EmployeeScheduleDto mapEmployeeScheduleToDto(EmployeeSchedule employeeSchedule) {
        EmployeeScheduleDto employeeScheduleDto = new EmployeeScheduleDto();
        employeeScheduleDto.setId(employeeSchedule.getId());
        employeeScheduleDto.setEmployeeId(employeeSchedule.getEmployeeId());
        employeeScheduleDto.setShiftStart(employeeSchedule.getShiftStart());
        employeeScheduleDto.setShiftEnd(employeeSchedule.getShiftEnd());
        employeeScheduleDto.setDayOfWeek(employeeSchedule.getDayOfWeek());
        return employeeScheduleDto;
    }

    // Employee DTO list
    public List<EmployeeDto> mapEmployeesToDtoList(List<Employee> employees) {
        return employees.stream()
                .map(this::mapEmployeeToDtoWithPositionAndDepartment)
                .collect(Collectors.toList());
    }

    // Position DTO list
    public List<PositionDto> mapPositionsToDtoList(List<Position> positions) {
        return positions.stream()
                .map(this::mapPositionToDto)
                .collect(Collectors.toList());
    }

    // Department DTO list
    public List<DepartmentDto> mapDepartmentsToDtoList(List<Department> departments) {
        return departments.stream()
                .map(this::mapDepartmentToDto)
                .collect(Collectors.toList());
    }

    // EmployeeSchedule DTO list
    public List<EmployeeScheduleDto> mapEmployeeSchedulesToDtoList(List<EmployeeSchedule> employeeSchedules) {
        return employeeSchedules.stream()
                .map(this::mapEmployeeScheduleToDto)
                .collect(Collectors.toList());
    }

    // Map Employee DTO to Employee entity
    public Employee mapEmployeeDtoToEntity(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDto.getEmployeeId().intValue());
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setAddress(employeeDto.getAddress());
        employee.setHireDate(employeeDto.getHireDate());

        // Handle Position and Department mappings
        if (employeeDto.getPositionId() != null) {
            Position position = new Position();
            position.setPositionId(employeeDto.getPositionId().intValue());
            employee.setPosition(position);
        }

        if (employeeDto.getDepartmentId() != null) {
            Department department = new Department();
            department.setDepartmentId(employeeDto.getDepartmentId().intValue());
            employee.setDepartment(department);
        }

        employee.setStatus(Employee.EmployeeStatus.valueOf(employeeDto.getStatus().name()));
        return employee;
    }

    // Map Position DTO to Position entity
    public Position mapPositionDtoToEntity(PositionDto positionDto) {
        Position position = new Position();
        position.setPositionId(positionDto.getPositionId());
        position.setPositionTitle(positionDto.getPositionTitle());
        return position;
    }

    // Map Department DTO to Department entity
    public Department mapDepartmentDtoToEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        department.setDepartmentId(departmentDto.getDepartmentId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        return department;
    }

    // Map EmployeeSchedule DTO to EmployeeSchedule entity
    public EmployeeSchedule mapEmployeeScheduleDtoToEntity(EmployeeScheduleDto employeeScheduleDto) {
        EmployeeSchedule employeeSchedule = new EmployeeSchedule();
        employeeSchedule.setId(employeeScheduleDto.getId());
        employeeSchedule.setEmployeeId(employeeScheduleDto.getEmployeeId());
        employeeSchedule.setShiftStart(employeeScheduleDto.getShiftStart());
        employeeSchedule.setShiftEnd(employeeScheduleDto.getShiftEnd());
        employeeSchedule.setDayOfWeek(employeeScheduleDto.getDayOfWeek());
        return employeeSchedule;
    }
}
