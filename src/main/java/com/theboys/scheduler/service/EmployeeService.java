package com.theboys.scheduler.service;

import com.theboys.scheduler.dao.EmployeeRepository;
import com.theboys.scheduler.dto.EmployeeDto;
import com.theboys.scheduler.entity.Employee;
import com.theboys.scheduler.mapper.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, EntityDtoMapper entityDtoMapper) {
        this.employeeRepository = employeeRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    public List<EmployeeDto> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return entityDtoMapper.mapEmployeesToDtoList(employees);
    }

    public EmployeeDto findEmployeeById(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        return employee.map(entityDtoMapper::mapEmployeeToDtoWithPositionAndDepartment)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = entityDtoMapper.mapEmployeeDtoToEntity(employeeDto);
        employee = employeeRepository.save(employee);
        return entityDtoMapper.mapEmployeeToDtoWithPositionAndDepartment(employee);
    }
    public void deleteEmployee(int employeeId) {
        employeeRepository.deleteById(employeeId);
    }

}
