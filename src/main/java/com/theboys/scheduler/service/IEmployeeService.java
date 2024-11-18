package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.EmployeeDto;
import java.util.List;

public interface IEmployeeService {
    List<EmployeeDto> findAllEmployees();
    EmployeeDto findEmployeeById(int employeeId);
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    void deleteEmployee(int employeeId);
}
