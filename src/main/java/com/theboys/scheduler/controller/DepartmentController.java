package com.theboys.scheduler.controller;

import com.theboys.scheduler.dto.DepartmentDto;
import com.theboys.scheduler.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments")
    public List<DepartmentDto> findAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable int departmentId) {
        DepartmentDto departmentDto = departmentService.findById(departmentId);
        return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartment = departmentService.save(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @PostMapping("/departments")
    public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto updatedDepartment = departmentService.save(departmentDto);
        return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
    }

    @DeleteMapping("/departments/{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable int departmentId) {
        departmentService.deleteById(departmentId);
        return new ResponseEntity<>("Dpeartment deleted successfully.", HttpStatus.OK);
    }
}
