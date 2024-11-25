package com.theboys.scheduler.seeder;

import com.theboys.scheduler.dao.DepartmentRepository;
import com.theboys.scheduler.dao.EmployeeRepository;
import com.theboys.scheduler.dao.PositionRepository;
import com.theboys.scheduler.entity.Department;
import com.theboys.scheduler.entity.Employee;
import com.theboys.scheduler.entity.Position;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;

    public DatabaseSeeder(EmployeeRepository employeeRepository,
                          PositionRepository positionRepository,
                          DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) {
        seedPositions();
        seedDepartments();
        seedEmployees();
    }

    private void seedPositions() {
        if (positionRepository.count() == 0) {
            Position manager = new Position(1, "Manager");
            Position developer = new Position(2, "Developer");
            Position projectManager = new Position(3, "Project Manager");

            positionRepository.saveAll(List.of(manager, developer, projectManager));
        }
    }

    private void seedDepartments() {
        if (departmentRepository.count() == 0) {
            Department hr = new Department(1, "Human Resources");
            Department it = new Department(2, "Information Technology");
            departmentRepository.saveAll(List.of(hr, it));
        }
    }

    private void seedEmployees() {
        if (employeeRepository.count() == 0) {
            // Fetch existing Position and Department
            Position manager = positionRepository.findById(1).orElseThrow(() -> new RuntimeException("Position not found"));
            Position developer = positionRepository.findById(2).orElseThrow(() -> new RuntimeException("Position not found"));
            Position projectManager = positionRepository.findById(3).orElseThrow(() -> new RuntimeException("Position not found"));


            Department hr = departmentRepository.findById(1).orElseThrow(() -> new RuntimeException("Department not found"));
            Department it = departmentRepository.findById(2).orElseThrow(() -> new RuntimeException("Department not found"));


            // Create Employees
            Employee employee1 = Employee.builder()
                    .firstName("Ajyol")
                    .lastName("Dhamala")
                    .email("ajyol.dhamala@selu.edu")
                    .phoneNumber("123-456-7890")
                    .address("123 Main St")
                    .hireDate(LocalDate.of(1111, 1, 11))
                    .position(manager)
                    .department(it)
                    .status(Employee.EmployeeStatus.ACTIVE)
                    .build();

            Employee employee2 = Employee.builder()
                    .firstName("Sarseej")
                    .lastName("Shrestha")
                    .email("sarseej.shrestha@selu.edu")
                    .phoneNumber("987-654-3210")
                    .address("456 Elm St")
                    .hireDate(LocalDate.of(2222, 2, 22))
                    .position(developer)
                    .department(hr)
                    .status(Employee.EmployeeStatus.INACTIVE)
                    .build();

            Employee employee3 = Employee.builder()
                    .firstName("Sudhakar")
                    .lastName("Chaulagain")
                    .email("sudhakar.chaulagain@selu.edu")
                    .phoneNumber("987-654-3210")
                    .address("456 Elm St")
                    .hireDate(LocalDate.of(3333, 4, 20))
                    .position(projectManager)
                    .department(hr)
                    .status(Employee.EmployeeStatus.TERMINATED)
                    .build();

            employeeRepository.saveAll(List.of(employee1, employee2, employee3));
        }
    }
}
