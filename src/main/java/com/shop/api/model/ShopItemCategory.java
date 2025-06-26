package com.shop.api.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ShopItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    // getters y setters
}
