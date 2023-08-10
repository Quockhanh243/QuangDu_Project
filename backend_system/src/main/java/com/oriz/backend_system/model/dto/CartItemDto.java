package com.oriz.backend_system.model.dto;

import com.oriz.backend_system.model.CartItem;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link CartItem}
 */
@Value
public class CartItemDto implements Serializable {
    Long id;
    String size;
    int quantity;
}