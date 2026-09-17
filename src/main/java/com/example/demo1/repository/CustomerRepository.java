package com.example.demo1.repository;

import com.example.demo1.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class CustomerRepository {
    HashMap<Integer, Customer> hm = new HashMap<>();

    public CustomerRepository(HashMap<Integer, Customer> hm) {
        this.hm = hm;
    }

    public CustomerRepository() {
    }

    public String setCustomer(Customer cust1) {
        hm.put(cust1.getId(), cust1);
        return "Customer added";
    }

    public Customer getCustomer(Integer id) {
        return hm.get(id);
    }

    public List<Customer> getCustomerList() {
        List<Customer> customerList = new ArrayList<>();

        for (Customer c : hm.values()) {
            customerList.add(c);
        }

        return customerList;
    }

    public boolean deleteCustomer(Integer id) {
        if (hm.containsKey(id)) {
            hm.remove(id);
            return true;
        }
        return false;
    }

    public Customer updateBalance(Integer id, int balance) {
        Customer customer = hm.get(id);

        if (customer != null) {
            customer.setBalance(balance);
        }

        return customer;
    }
    public Customer patchCustomer(Integer id, int balance) {
        Customer customer = hm.get(id);

        if (customer != null) {
            customer.setBalance(balance);
            hm.put(id, customer);
        }

        return customer;
    }

}