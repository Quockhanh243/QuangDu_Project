package com.oriz.backend_system.model.dto;

import com.oriz.backend_system.model.Product;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link Product}
 */
@Value
public class ProductDto implements Serializable {
    Long id;
    String title;
    String description;
    int price;
    int discountedPrice;
    int discountPercent;
    int quantity;
    String brand;
    String color;
    String imageUrl;
    int numRatings;
    LocalDateTime createdAt;
}