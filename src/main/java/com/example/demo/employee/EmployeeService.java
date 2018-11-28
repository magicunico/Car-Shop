package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

     List<Employee> getEmployees(){return employeeRepository.findAll();}

     void addEmployee(Employee employee){employeeRepository.save(employee);}

     void deleteEmployee(Long id){employeeRepository.deleteById(id);}

     void updateEmployee(EmployeeDTO employeeDTO){
        Employee employee = employeeRepository.findById(employeeDTO.getId()).orElseThrow(()-> new IllegalArgumentException("Employee not found"));
        if(employeeDTO.getAddress() != null && employeeDTO.getAddress().isEmpty() ){
            employee.setAddress(employeeDTO.getAddress());
        }

        employee.setDate(employeeDTO.getDate());

         if(employeeDTO.getName() != null && employeeDTO.getName().isEmpty() ){
             employee.setName(employeeDTO.getName());
         }
         if(employeeDTO.getPesel() != null && employeeDTO.getPesel().isEmpty() ){
             employee.setPesel(employeeDTO.getPesel());
         }
         if(employeeDTO.getSurname() != null && employeeDTO.getSurname().isEmpty() ){
             employee.setSurname(employeeDTO.getSurname());
         }
         employee.setSalary(employeeDTO.getSalary());

         employeeRepository.save(employee);
     }
}
