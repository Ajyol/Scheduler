package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.DepartmentDto;
import com.theboys.scheduler.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentDto> findAll();
    DepartmentDto findById(int theId);
    DepartmentDto save(Department theDepartment);
    void deleteById(int theId);
}
