package com.example.demo.employee;

import jdk.nashorn.internal.codegen.CompilerConstants;
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
    private EmployeeRepository employeeRepository;

    public Connection conn;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

     List<Employee> getEmployees(){return employeeRepository.findAll();}

     void addEmployee(Employee employee){employeeRepository.save(employee);}

     void deleteEmployee(Long id){
        Employee employee = employeeRepository.findById(id).get();
        employee.setNonactive();
        employeeRepository.save(employee);
    }

     void updateEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElseThrow(()-> new IllegalArgumentException("Employee not found"));

        employee.setAddress(employeeDTO.getAddress());
        employee.setDate(employeeDTO.getDate());
        employee.setName(employeeDTO.getName());
        employee.setPesel(employeeDTO.getPesel());
        employee.setSurname(employeeDTO.getSurname());
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
     }

     public Integer countEmployees(){
        String proc = "SELECT \"hired\" ()";
        Query query=entityManager.createNativeQuery(proc);
        return (Integer) query.getSingleResult();
     }


    @Transactional
    public void prom(EmployeePromotion employeePromotion) {
        String queryString = "SELECT \"promote\"(%d, %d)";
        queryString = String.format(queryString, employeePromotion.getEmployee(),employeePromotion.getHowmuch());
        Query query = entityManager.createNativeQuery(queryString);
        query.getSingleResult();
    }

     List<Employee> getActive(){
        return employeeRepository.findAll().stream().filter( a -> a.getStatus().equals(1))
                .collect(Collectors.toList());
     }

     Employee getEmployee(Long id){
        return employeeRepository.findById(id).get();
     }
}
