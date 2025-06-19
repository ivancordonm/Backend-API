package com.shop.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.api.entity.Customer;
import com.shop.api.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureTestMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureTestMvc
@Transactional
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        customerRepository.deleteAll();
        testCustomer = new Customer("Test", "User", "test@example.com");
        testCustomer = customerRepository.save(testCustomer);
    }

    @Test
    void getAllCustomers() throws Exception {
        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("Test"))
                .andExpect(jsonPath("$[0].surname").value("User"))
                .andExpect(jsonPath("$[0].email").value("test@example.com"));
    }

    @Test
    void getCustomerById() throws Exception {
        mockMvc.perform(get("/api/customers/{id}", testCustomer.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test"))
                .andExpect(jsonPath("$.surname").value("User"))
                .andExpect(jsonPath("$.email").value("test@example.com"));
    }

    @Test
    void createCustomer() throws Exception {
        Customer newCustomer = new Customer("New", "Customer", "new@example.com");
        
        mockMvc.perform(post("/api/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newCustomer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("New"))
                .andExpect(jsonPath("$.surname").value("Customer"))
                .andExpect(jsonPath("$.email").value("new@example.com"));
    }

    @Test
    void updateCustomer() throws Exception {
        Customer updatedCustomer = new Customer("Updated", "Name", "updated@example.com");
        
        mockMvc.perform(put("/api/customers/{id}", testCustomer.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedCustomer)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated"))
                .andExpect(jsonPath("$.surname").value("Name"))
                .andExpect(jsonPath("$.email").value("updated@example.com"));
    }

    @Test
    void deleteCustomer() throws Exception {
        mockMvc.perform(delete("/api/customers/{id}", testCustomer.getId()))
                .andExpect(status().isOk());
        
        mockMvc.perform(get("/api/customers/{id}", testCustomer.getId()))
                .andExpect(status().isNotFound());
    }
}