package com.example.demo.employee;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Employee> getAll(){return employeeService.getEmployees();}

    @PostMapping(value = "/add")
    public void addEmployee(@RequestBody Employee employee){employeeService.addEmployee(employee);}

    @DeleteMapping(value = "delete/{id}")
    public void deleteEmployee(@PathVariable Long id){employeeService.deleteEmployee(id);}
}
