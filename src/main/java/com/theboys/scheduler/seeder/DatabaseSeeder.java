package com.theboys.scheduler.seeder;

import com.theboys.scheduler.dao.*;
import com.theboys.scheduler.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;
    private final AttendanceRepository attendanceRepository;
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public DatabaseSeeder(EmployeeRepository employeeRepository, PositionRepository positionRepository, DepartmentRepository departmentRepository, AttendanceRepository attendanceRepository, ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.departmentRepository = departmentRepository;
        this.attendanceRepository = attendanceRepository;
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        seedPositions();
        seedDepartments();
        seedEmployees();
        seedSchedules();
        seedAttendances();
        seedUsers();
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
            Position manager = positionRepository.findById(1).orElseThrow(() -> new RuntimeException("Position not found"));
            Position developer = positionRepository.findById(2).orElseThrow(() -> new RuntimeException("Position not found"));
            Position projectManager = positionRepository.findById(3).orElseThrow(() -> new RuntimeException("Position not found"));

            Department hr = departmentRepository.findById(1).orElseThrow(() -> new RuntimeException("Department not found"));
            Department it = departmentRepository.findById(2).orElseThrow(() -> new RuntimeException("Department not found"));

            Employee employee1 = Employee.builder()
                    .firstName("Ajyol")
                    .lastName("Dhamala")
                    .email("ajyol.dhamala@selu.edu")
                    .phoneNumber("123-456-7890")
                    .address("123 Main St")
                    .hireDate(LocalDate.of(2023, 1, 15))
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
                    .hireDate(LocalDate.of(2023, 5, 20))
                    .position(developer)
                    .department(hr)
                    .status(Employee.EmployeeStatus.INACTIVE)
                    .build();

            Employee employee3 = Employee.builder()
                    .firstName("Sudhakar")
                    .lastName("Chaulagain")
                    .email("sudhakar.chaulagain@selu.edu")
                    .phoneNumber("789-456-1230")
                    .address("789 Pine St")
                    .hireDate(LocalDate.of(2023, 7, 10))
                    .position(projectManager)
                    .department(it)
                    .status(Employee.EmployeeStatus.TERMINATED)
                    .build();

            employeeRepository.saveAll(List.of(employee1, employee2, employee3));
        }
    }

    private void seedSchedules() {
        if (scheduleRepository.count() == 0) {
            Employee employee1 = employeeRepository.findById(1).orElseThrow(() -> new RuntimeException("Employee not found"));
            Employee employee2 = employeeRepository.findById(2).orElseThrow(() -> new RuntimeException("Employee not found"));

            Schedule schedule1 = Schedule.builder()
                    .employee(employee1)
                    .shiftDate(LocalDate.of(2024, 11, 25))
                    .shiftStart(LocalTime.of(9, 0))
                    .shiftEnd(LocalTime.of(17, 0))
                    .status(Schedule.ScheduleStatus.SCHEDULED)
                    .build();

            Schedule schedule2 = Schedule.builder()
                    .employee(employee2)
                    .shiftDate(LocalDate.of(2024, 11, 25))
                    .shiftStart(LocalTime.of(10, 0))
                    .shiftEnd(LocalTime.of(18, 0))
                    .status(Schedule.ScheduleStatus.COMPLETED)
                    .build();

            scheduleRepository.saveAll(List.of(schedule1, schedule2));
        }
    }

    private void seedAttendances() {
        if (attendanceRepository.count() == 0) {
            Employee employee1 = employeeRepository.findById(1).orElseThrow(() -> new RuntimeException("Employee not found"));
            Schedule schedule1 = scheduleRepository.findById(1).orElseThrow(() -> new RuntimeException("Schedule not found"));

            Attendance attendance1 = Attendance.builder()
                    .employee(employee1)
                    .schedule(schedule1)
                    .clockIn(LocalTime.of(9, 0))
                    .clockOut(LocalTime.of(17, 0))
                    .status(Attendance.AttendanceStatus.PRESENT)
                    .build();

            attendanceRepository.save(attendance1);
        }
    }

    private void seedUsers() {
        if (userRepository.count() == 0) {
            Employee employee1 = employeeRepository.findById(1).orElseThrow(() -> new RuntimeException("Employee not found"));

            User adminUser = User.builder()
                    .username("admin")
                    .password("password123") // Ensure this is securely hashed in production
                    .role(User.UserRole.ADMIN)
                    .employee(employee1)
                    .build();

            userRepository.save(adminUser);
        }
    }
}
