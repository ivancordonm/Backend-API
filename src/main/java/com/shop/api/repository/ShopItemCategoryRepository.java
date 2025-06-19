package com.shop.api.repository;

import com.shop.api.entity.ShopItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemCategoryRepository extends JpaRepository<ShopItemCategory, Long> {
}