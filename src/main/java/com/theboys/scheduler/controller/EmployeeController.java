package com.theboys.scheduler.controller;

import com.theboys.scheduler.entity.Employee;
import com.theboys.scheduler.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private IEmployeeService context;

    @Autowired
    public EmployeeController(IEmployeeService context) {
        this.context = context;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return context.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = context.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }
        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setEmployeeId(0);
        return context.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return context.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee theEmployee = context.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee not found - " + employeeId);
        }

        context.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }
}
