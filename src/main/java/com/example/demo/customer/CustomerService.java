package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

     List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

     void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

     void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

     void updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getId()).orElseThrow(()-> new IllegalArgumentException("customer not found"));
        if(customerDTO.getAddress() != null && !customerDTO.getAddress().isEmpty()){
            customer.setAddress(customerDTO.getAddress());
        }
         if(customerDTO.getName() != null && !customerDTO.getName().isEmpty()){
             customer.setName(customerDTO.getName());
         }

         if(customerDTO.getPesel() != null && !customerDTO.getPesel().isEmpty()){
             customer.setPesel(customerDTO.getPesel());
         }

         if(customerDTO.getSurname() != null && !customerDTO.getSurname().isEmpty()){
             customer.setSurname(customerDTO.getSurname());
         }
         customerRepository.save(customer);
     }
}