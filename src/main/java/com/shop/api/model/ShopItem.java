package com.shop.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ShopItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private float price;

    @JoinTable(
            name = "shopitem_category",
            joinColumns = @JoinColumn(name = "shopitem_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<ShopItemCategory> categories;

}
