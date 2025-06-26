package com.shop.api;

import com.shop.api.model.*;
import com.shop.api.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(CustomerRepository customerRepo,
                               ShopItemCategoryRepository categoryRepo,
                               ShopItemRepository itemRepo,
                               OrderItemRepository orderItemRepo,
                               OrderRepository orderRepo) {
        return args -> {
            // Clientes
            Customer c1 = new Customer();
            c1.setName("Juan"); c1.setSurname("Pérez"); c1.setEmail("juan@example.com");
            Customer c2 = new Customer();
            c2.setName("Ana"); c2.setSurname("López"); c2.setEmail("ana@example.com");
            customerRepo.saveAll(List.of(c1, c2));

            // Categorías
            ShopItemCategory cat1 = new ShopItemCategory();
            cat1.setTitle("Electrónica"); cat1.setDescription("Dispositivos electrónicos");
            ShopItemCategory cat2 = new ShopItemCategory();
            cat2.setTitle("Libros"); cat2.setDescription("Libros y revistas");
            categoryRepo.saveAll(List.of(cat1, cat2));

            // Productos
            ShopItem item1 = new ShopItem();
            item1.setTitle("Smartphone"); item1.setDescription("Teléfono móvil"); item1.setPrice(299.99f);
            item1.setCategories(List.of(cat1));
            ShopItem item2 = new ShopItem();
            item2.setTitle("Libro Java"); item2.setDescription("Aprende Java"); item2.setPrice(39.99f);
            item2.setCategories(List.of(cat2));
            itemRepo.saveAll(List.of(item1, item2));

            // OrderItems
            OrderItem oi1 = new OrderItem();
            oi1.setShopItem(item1); oi1.setQuantity(1);
            OrderItem oi2 = new OrderItem();
            oi2.setShopItem(item2); oi2.setQuantity(2);
            orderItemRepo.saveAll(List.of(oi1, oi2));

            // Pedidos
            Order o1 = new Order();
            o1.setCustomer(c1);
            o1.setItems(List.of(oi1, oi2));
            orderRepo.save(o1);
        };
    }
}
