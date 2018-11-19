package com.example.demo.employee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(){return employeeRepository.findAll();}

    public void addEmployee(Employee employee){employeeRepository.save(employee);}

    public void deleteEmployee(Long id){employeeRepository.deleteById(id);}
}
