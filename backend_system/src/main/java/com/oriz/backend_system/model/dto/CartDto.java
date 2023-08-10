package com.oriz.backend_system.model.dto;

import com.oriz.backend_system.model.Cart;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Cart}
 */
@Value
public class CartDto implements Serializable {
    Long id;
    double totalPrice;
    double totalItem;
    int totalDiscountdePrice;
    int discount;
}