package com.shop.api.controller;

import com.shop.api.entity.ShopItem;
import com.shop.api.repository.ShopItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ShopItemController {

    @Autowired
    private ShopItemRepository shopItemRepository;

    @GetMapping
    public List<ShopItem> getAllItems() {
        return shopItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopItem> getItemById(@PathVariable Long id) {
        return shopItemRepository.findById(id)
                .map(item -> ResponseEntity.ok().body(item))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShopItem createItem(@Valid @RequestBody ShopItem item) {
        return shopItemRepository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopItem> updateItem(@PathVariable Long id, @Valid @RequestBody ShopItem itemDetails) {
        return shopItemRepository.findById(id)
                .map(item -> {
                    item.setTitle(itemDetails.getTitle());
                    item.setDescription(itemDetails.getDescription());
                    item.setPrice(itemDetails.getPrice());
                    item.setCategories(itemDetails.getCategories());
                    return ResponseEntity.ok(shopItemRepository.save(item));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable Long id) {
        return shopItemRepository.findById(id)
                .map(item -> {
                    shopItemRepository.delete(item);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}