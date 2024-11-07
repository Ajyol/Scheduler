package service;

import dao.EmployeeRepository;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository context;

    @Autowired
    public EmployeeService(EmployeeRepository context) {
        this.context = context;
    }

    @Override
    public List<Employee> findAll() {
        return context.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = context.findById((long) theId);
        return result.orElseThrow(() -> new RuntimeException("Invalid ID: " + theId));
    }

    @Override
    public Employee save(Employee theEmployee) {
        return context.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        context.deleteById((long) theId);
    }
}
