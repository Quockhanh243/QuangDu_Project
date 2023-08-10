package com.oriz.backend_system.services;

import com.oriz.backend_system.model.OrderItem;

public interface OrderItemService {
    OrderItem getOrderItemById(Long id);

    OrderItem addOrderItem(OrderItem orderItem);

    OrderItem updateOrderItem(Long id, OrderItem orderItem);

    void deleteOrderItem(Long id);

    // Add methods for OrderItem-related operations
}
