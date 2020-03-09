package com.example.demo.customer;


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

    @CrossOrigin("*")
    @PostMapping(value = "/add")
    public void addCustomer(@RequestBody Customer customer){customerService.addCustomer(customer);}

    @CrossOrigin("*")
    @DeleteMapping(value = "/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

    @CrossOrigin("*")
    @PutMapping(value = "/update")
    public void updateCustomer(@RequestBody CustomerDTO customerDTO){customerService.updateCustomer(customerDTO);}

    @CrossOrigin("*")
    @GetMapping("/active")
    public List<Customer> getActive(){
        return customerService.getActive();
    }

    @CrossOrigin("*")
    @GetMapping("{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getCustomer(id);
    }
}
