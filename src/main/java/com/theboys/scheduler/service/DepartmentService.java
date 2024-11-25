package com.theboys.scheduler.service;

import com.theboys.scheduler.dao.DepartmentRepository;
import com.theboys.scheduler.dto.DepartmentDto;
import com.theboys.scheduler.entity.Department;
import com.theboys.scheduler.exception.DepartmentNotFoundException;
import com.theboys.scheduler.mapper.EntityDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EntityDtoMapper entityDtoMapper;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EntityDtoMapper entityDtoMapper) {
        this.departmentRepository = departmentRepository;
        this.entityDtoMapper = entityDtoMapper;
    }

    @Override
    public List<DepartmentDto> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return entityDtoMapper.mapDepartmentsToDtoList(departments);
    }

    @Override
    public DepartmentDto findById(int theId) {
        Optional<Department> department = departmentRepository.findById(theId);
        return department.map(entityDtoMapper::mapDepartmentToDto)
                .orElseThrow(() -> new DepartmentNotFoundException("Department with ID " + theId + " not found"));
    }

    @Override
    public DepartmentDto save(DepartmentDto theDepartment) {
        Department department = entityDtoMapper.mapDepartmentDtoToEntity(theDepartment);
        department = departmentRepository.save(department);
        return entityDtoMapper.mapDepartmentToDto(department);
    }

    @Override
    public void deleteById(int theId) {
        if (!departmentRepository.existsById(theId)) {
            throw new DepartmentNotFoundException("Department with ID " + theId + " not found");
        }
        departmentRepository.deleteById(theId);
    }
}
