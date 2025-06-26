package com.shop.api.controller;

import com.shop.api.model.Order;
import com.shop.api.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderRepository repository;
    public OrderController(OrderRepository repository) { this.repository = repository; }

    @GetMapping
    public List<Order> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Integer id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public Order create(@RequestBody Order order) { return repository.save(order); }

    @PutMapping("/{id}")
    public Order update(@PathVariable Integer id, @RequestBody Order order) {
        Order existing = repository.findById(id).orElse(null);
        if (existing == null) return null;
        order.setId(id);
        return repository.save(order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repository.deleteById(id); }
}
