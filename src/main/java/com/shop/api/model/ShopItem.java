package com.shop.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private float price;

    @ManyToMany
    @JoinTable(
        name = "shopitem_category",
        joinColumns = @JoinColumn(name = "shopitem_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<ShopItemCategory> categories;
    // getters y setters
}
