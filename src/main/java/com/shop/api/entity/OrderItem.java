package com.shop.api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_item_id", nullable = false)
    private ShopItem shopItem;

    @NotNull
    @Positive
    @Column(nullable = false)
    private Integer quantity;

    public OrderItem() {}

    public OrderItem(ShopItem shopItem, Integer quantity) {
        this.shopItem = shopItem;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public ShopItem getShopItem() { return shopItem; }
    public void setShopItem(ShopItem shopItem) { this.shopItem = shopItem; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}