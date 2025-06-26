package com.shop.api.controller;

import com.shop.api.model.ShopItem;
import com.shop.api.repository.ShopItemRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ShopItemController {
    private final ShopItemRepository repository;
    public ShopItemController(ShopItemRepository repository) { this.repository = repository; }

    @GetMapping
    public List<ShopItem> getAll() { return repository.findAll(); }

    @GetMapping("/{id}")
    public ShopItem getById(@PathVariable Integer id) { return repository.findById(id).orElse(null); }

    @PostMapping
    public ShopItem create(@RequestBody ShopItem item) { return repository.save(item); }

    @PutMapping("/{id}")
    public ShopItem update(@PathVariable Integer id, @RequestBody ShopItem item) {
        item.setId(id);
        return repository.save(item);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { repository.deleteById(id); }
}
