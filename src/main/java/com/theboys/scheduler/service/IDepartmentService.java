package com.theboys.scheduler.service;

import com.theboys.scheduler.dto.DepartmentDto;

import java.util.List;

public interface IDepartmentService {
    List<DepartmentDto> findAll();
    DepartmentDto findById(int theId);
    DepartmentDto save(DepartmentDto theDepartment);
    void deleteById(int theId);
}
