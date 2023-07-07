package org.example.service;

import org.example.entity.Customer;
import org.example.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private CustomerRepo customerRepo;

    @Autowired
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer getById(Long id){
        return customerRepo.findById(id).orElseThrow();
    }

    public Customer getCustomerById(Long id) {return customerRepo.findCustomerById(id).orElseThrow(); }

    public void update(Customer customer){
        customerRepo.save(customer);
    }

    public Customer getByLoginStartsWithIgnoreCase(String symbols){
        return customerRepo.findByLoginStartsWithIgnoreCase(symbols).orElseThrow();
    }

    public void terminateCustomerByName(String name){
        customerRepo.deleteByLoginIgnoreCase(name);
    }

    public void updateCustomerLoginById(Long id, String newName){
        customerRepo.updateLoginById(newName,id);

    }

    public void saveSomeCustomer(Customer customer){
        customerRepo.save(customer);
    }


}
