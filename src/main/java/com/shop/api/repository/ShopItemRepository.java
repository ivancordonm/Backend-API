package com.shop.api.repository;

import com.shop.api.model.ShopItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopItemRepository extends JpaRepository<ShopItem, Integer> {
}
