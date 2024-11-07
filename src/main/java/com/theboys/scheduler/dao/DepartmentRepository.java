package com.theboys.scheduler.dao;

import com.theboys.scheduler.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
