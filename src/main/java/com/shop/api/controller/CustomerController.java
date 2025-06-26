package com.shop.api.controller;

import com.shop.api.model.Customer;
import com.shop.api.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerRepository repository;
    public CustomerController(CustomerRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Customer> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Customer getById(@PathVariable Integer id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public Customer create(@RequestBody Customer c) { return repository.save(c); }

    @PutMapping("/{id}")
    public Customer update(@PathVariable Integer id, @RequestBody Customer c) {
        c.setId(id);
        return repository.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repository.deleteById(id); }
}
