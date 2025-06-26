package com.shop.api.controller;

import com.shop.api.model.ShopItemCategory;
import com.shop.api.repository.ShopItemCategoryRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ShopItemCategoryController {
    private final ShopItemCategoryRepository repository;
    public ShopItemCategoryController(ShopItemCategoryRepository repository) { this.repository = repository; }

    @GetMapping
    public List<ShopItemCategory> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ShopItemCategory getById(@PathVariable Integer id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public ShopItemCategory create(@RequestBody ShopItemCategory c) { return repository.save(c); }

    @PutMapping("/{id}")
    public ShopItemCategory update(@PathVariable Integer id, @RequestBody ShopItemCategory c) {
        c.setId(id);
        return repository.save(c);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repository.deleteById(id); }
}
