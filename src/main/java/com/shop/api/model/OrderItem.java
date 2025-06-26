package com.shop.api.model;

import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "shopitem_id")
    private ShopItem shopItem;

    private Integer quantity;
    // getters y setters
}
