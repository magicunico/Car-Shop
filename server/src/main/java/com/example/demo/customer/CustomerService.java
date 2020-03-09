package com.example.demo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        Customer customer = customerRepository.findById(id).get();
        customer.setNonctive();
        customerRepository.save(customer);
    }

     void updateCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(customerDTO.getId()).orElseThrow(()-> new IllegalArgumentException("customer not found"));
            customer.setAddress(customerDTO.getAddress());
            customer.setName(customerDTO.getName());
            customer.setPesel(customerDTO.getPesel());
            customer.setSurname(customerDTO.getSurname());
            customerRepository.save(customer);
     }

    List<Customer> getActive(){
        return customerRepository.findAll().stream().filter( a -> a.getStatus().equals(1))
                .collect(Collectors.toList());
    }

    Customer getCustomer(Long id){
        return customerRepository.findById(id).get();
    }

}