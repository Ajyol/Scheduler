package com.theboys.scheduler.dao;

import com.theboys.scheduler.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
