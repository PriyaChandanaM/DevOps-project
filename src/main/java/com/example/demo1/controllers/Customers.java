package com.example.demo1.controllers;

import com.example.demo1.model.Customer;
import com.example.demo1.service.CustomerService;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class Customers {

    private final CustomerService service;

    public Customers(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomerList();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable int id) {
        Customer c = service.getCustomer(id);

        if (c == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(c, HttpStatus.FOUND);
    }

    @PostMapping("/list")
    public List<Customer> createCustomerList(@RequestBody List<Customer> customers) {
        return service.setCustomerList(customers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int id, @RequestParam int balance) {
        Customer customer = service.updateBalance(id, balance);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Customer> patchCustomer(@PathVariable int id, @RequestParam int balance) {
        Customer customer = service.updateBalance(id, balance);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable int id) {
        boolean deleted = service.deleteCustomer(id);

        if (!deleted) {
            return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}