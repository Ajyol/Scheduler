package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.EmployeeDto;
import com.theboys.scheduler.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDto> findAll();
    EmployeeDto findById(int theId);
    EmployeeDto save(Employee theEmployee);
    void deleteById(int theId);
}
