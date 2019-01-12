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

    @CrossOrigin(origins = "*")
    @PostMapping(value = "/add")
    public void addEmployee(@RequestBody Employee employee){employeeService.addEmployee(employee);}

    @CrossOrigin("*")
    @DeleteMapping(value = "delete/{id}")
    public void deleteEmployee(@PathVariable Long id){employeeService.deleteEmployee(id);}

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody EmployeeDTO employeeDTO ){employeeService.updateEmployee(employeeDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Employee> getActive(){
        return employeeService.getActive();
    }

    @CrossOrigin("*")
    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }
}
