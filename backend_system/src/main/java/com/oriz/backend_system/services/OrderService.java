package com.oriz.backend_system.services;

import com.oriz.backend_system.model.Order;

public interface OrderService {
    Order getOrderById(Long id);

    Order addOrder(Order order);

    Order updateOrder(Long id, Order order);

    void deleteOrder(Long id);

    // Add methods for Order-related operations
}
