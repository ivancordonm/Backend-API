package com.shop.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop_item_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    public ShopItemCategory(String title, String description) {
        this.title = title;
        this.description = description;
    }
}