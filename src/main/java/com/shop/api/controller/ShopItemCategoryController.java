package com.shop.api.controller;

import com.shop.api.entity.ShopItemCategory;
import com.shop.api.repository.ShopItemCategoryRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class ShopItemCategoryController {

    @Autowired
    private ShopItemCategoryRepository categoryRepository;

    @GetMapping
    public List<ShopItemCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopItemCategory> getCategoryById(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShopItemCategory createCategory(@Valid @RequestBody ShopItemCategory category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShopItemCategory> updateCategory(@PathVariable Long id, @Valid @RequestBody ShopItemCategory categoryDetails) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setTitle(categoryDetails.getTitle());
                    category.setDescription(categoryDetails.getDescription());
                    return ResponseEntity.ok(categoryRepository.save(category));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        return categoryRepository.findById(id)
                .map(category -> {
                    categoryRepository.delete(category);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}