package com.shop.api.config;

import com.shop.api.entity.*;
import com.shop.api.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ShopItemCategoryRepository categoryRepository;
    
    @Autowired
    private ShopItemRepository shopItemRepository;
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize test data
        initializeTestData();
    }

    private void initializeTestData() {
        // Create customers
        Customer customer1 = new Customer("John", "Doe", "john.doe@example.com");
        Customer customer2 = new Customer("Jane", "Smith", "jane.smith@example.com");
        customerRepository.save(customer1);
        customerRepository.save(customer2);

        // Create categories
        ShopItemCategory electronics = new ShopItemCategory("Electronics", "Electronic devices and gadgets");
        ShopItemCategory clothing = new ShopItemCategory("Clothing", "Fashion and apparel");
        ShopItemCategory books = new ShopItemCategory("Books", "Books and literature");
        categoryRepository.save(electronics);
        categoryRepository.save(clothing);
        categoryRepository.save(books);

        // Create shop items
        ShopItem laptop = new ShopItem("Gaming Laptop", "High-performance gaming laptop", new BigDecimal("1299.99"));
        laptop.setCategories(Set.of(electronics));
        
        ShopItem tshirt = new ShopItem("Cotton T-Shirt", "Comfortable cotton t-shirt", new BigDecimal("29.99"));
        tshirt.setCategories(Set.of(clothing));
        
        ShopItem novel = new ShopItem("Programming Book", "Learn Java programming", new BigDecimal("49.99"));
        novel.setCategories(Set.of(books));
        
        shopItemRepository.save(laptop);
        shopItemRepository.save(tshirt);
        shopItemRepository.save(novel);

        // Create orders
        Order order1 = new Order(customer1);
        OrderItem orderItem1 = new OrderItem(laptop, 1);
        OrderItem orderItem2 = new OrderItem(tshirt, 2);
        order1.getItems().add(orderItem1);
        order1.getItems().add(orderItem2);
        
        Order order2 = new Order(customer2);
        OrderItem orderItem3 = new OrderItem(novel, 1);
        order2.getItems().add(orderItem3);
        
        orderRepository.save(order1);
        orderRepository.save(order2);
    }
}