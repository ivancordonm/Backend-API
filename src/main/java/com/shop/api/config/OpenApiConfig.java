package com.shop.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Online Shop Backend API")
                        .version("1.0.0")
                        .description("REST API for managing customers, shop items, categories, and orders in an online shop")
                        .contact(new Contact()
                                .name("Shop API Team")
                                .email("api@shop.com")));
    }
}