package service;

import dao.EmployeeRepository;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements IEmployeeService{

    private EmployeeRepository context;

    @Autowired
    public EmployeeService(EmployeeRepository _context) {
        context = _context;
    }

    @Override
    public List<Employee> findAll() {
        return context.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = context.findById(theId);
        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        } else {
            throw new RuntimeException("Invalid ID: " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return context.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        context.deleteById(theId);
    }
}
