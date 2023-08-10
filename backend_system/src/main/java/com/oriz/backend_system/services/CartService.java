package com.oriz.backend_system.services;

import com.oriz.backend_system.model.Cart;

public interface CartService {
    Cart getCartByCustomerId(Long customerId);

    Cart createCartForCustomer(Long customerId);

    Cart updateCart(Cart cart);

    void deleteCart(Long cartId);
}
