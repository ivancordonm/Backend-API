package com.shop.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ShopItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;
}
