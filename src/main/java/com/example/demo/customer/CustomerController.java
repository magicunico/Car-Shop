package com.example.demo.customer;

import com.example.demo.testdrive.TestDriveService;
import com.example.demo.testdrive.Testdrive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/all")
    public List<Customer> getAll(){return customerService.getCustomers();}

    @PostMapping(value = "/add")
    public void addCustomer(@RequestBody Customer customer){customerService.addCustomer(customer);}


    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){customerService.deleteCustomer(id);}

    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO){customerService.updateCustomer(customerDTO);}
}
