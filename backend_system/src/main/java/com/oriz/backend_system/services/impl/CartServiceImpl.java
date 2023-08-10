package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.Cart;
import com.oriz.backend_system.repositories.CartRepository;
import com.oriz.backend_system.services.CartService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId);
    }

    @Override
    public Cart createCartForCustomer(Long customerId) {

        Cart existingCart = cartRepository.findByCustomerId(customerId);
        if (existingCart != null) {
            return existingCart;
        }

        Cart newCart = new Cart();

        return cartRepository.save(newCart);
    }

    @Override
    public Cart updateCart(Cart cart) {
        if (cart.getId() != null) {
            return cartRepository.save(cart);
        }
        return null;
    }

    @Override
    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
