package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

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

     List<Employee> getActive(){
        return employeeRepository.findAll().stream().filter( a -> a.getStatus().equals(1))
                .collect(Collectors.toList());
     }

     Employee getEmployee(Long id){
        return employeeRepository.findById(id).get();
     }
}
