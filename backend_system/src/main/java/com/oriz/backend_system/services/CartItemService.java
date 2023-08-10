package com.oriz.backend_system.services;

import com.oriz.backend_system.model.CartItem;
import com.oriz.backend_system.model.dto.CartItemDto;

public interface CartItemService {
    CartItem getCartItemById(Long id);

    CartItem addCartItem(CartItem cartItem);

    CartItem updateCartItem(Long id, CartItemDto cartItem);

    void deleteCartItem(Long id);

    // Add methods for CartItem-related operations
}
