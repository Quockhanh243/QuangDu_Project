package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.CartItem;
import com.oriz.backend_system.model.dto.CartItemDto;
import com.oriz.backend_system.repositories.CartItemRepository;
import com.oriz.backend_system.services.CartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    @Override
    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem updateCartItem(Long id, CartItemDto cartItem) {
        CartItem existingCartItem = cartItemRepository.findById(id).orElse(null);
        if (existingCartItem != null) {
            existingCartItem.setSize(cartItem.getSize());
            existingCartItem.setQuantity(cartItem.getQuantity());
            // Set other properties as needed
            return cartItemRepository.save(existingCartItem);
        }
        return null; // CartItem ID is missing or not found
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    // Implement methods for CartItem-related operations
}
