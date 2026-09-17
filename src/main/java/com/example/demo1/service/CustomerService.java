package com.example.demo1.service;

import com.example.demo1.model.Customer;
import com.example.demo1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public Customer getCustomer(Integer id) {
        return repository.getCustomer(id);
    }


    public List<Customer> setCustomerList(List<Customer> customers) {
        for (Customer customer : customers) {
            repository.setCustomer(customer);
        }
        return customers;
    }
    public List<Customer> getCustomerList() {
        return repository.getCustomerList();
    }

    public boolean deleteCustomer(Integer id) {
        return repository.deleteCustomer(id);
    }
    public Customer updateBalance(Integer id, int balance) {
        return repository.updateBalance(id, balance);
    }
    public Customer patchCustomer(Integer id, int balance) {
        return repository.patchCustomer(id, balance);
    }
}