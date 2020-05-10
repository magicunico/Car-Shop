package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


@Service
public class EmployeeService {
    public Connection conn;
    private EmployeeRepository employeeRepository;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id).get();
        employee.setNonactive();
        employeeRepository.save(employee);
    }

    void updateEmployee(Employee employeeDTO) {
        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        employee.setAddress(employeeDTO.getAddress());
        employee.setDate(employeeDTO.getDate());
        employee.setName(employeeDTO.getName());
        employee.setPesel(employeeDTO.getPesel());
        employee.setSurname(employeeDTO.getSurname());
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
    }

    @Transactional
    public int countEmployees() {
        return (int) employeeRepository.findAll()
            .stream()
            .filter(employee -> employee.getStatus()==1).count();
    }


    @Transactional
    public void prom(EmployeePromotion employeePromotion) {
       Employee employee = employeeRepository.findById(employeePromotion.getEmployee())
           .orElseThrow(()-> new IllegalArgumentException(""));
       employee.setSalary(employee.getSalary()+employeePromotion.getHowmuch());
       employeeRepository.save(employee);
    }

    List<Employee> getActive() {
        return employeeRepository.findAll().stream().filter(a -> a.getStatus()==1)
                .collect(Collectors.toList());
    }

    Employee getEmployee(long id) {
        return employeeRepository.findById(id).get();
    }
}
