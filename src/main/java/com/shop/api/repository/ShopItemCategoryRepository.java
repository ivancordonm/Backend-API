package com.shop.api.repository;

import com.shop.api.model.ShopItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopItemCategoryRepository extends JpaRepository<ShopItemCategory, Integer> {
}
