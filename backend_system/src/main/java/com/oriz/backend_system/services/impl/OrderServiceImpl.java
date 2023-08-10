package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.Order;
import com.oriz.backend_system.repositories.OrderRepository;
import com.oriz.backend_system.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order updatedOrder = existingOrder.get();
            updatedOrder.setOrderId(order.getOrderId());
            updatedOrder.setCustomer(order.getCustomer());
            updatedOrder.setOrderItems(order.getOrderItems());
            updatedOrder.setOrderDate(order.getOrderDate());
            updatedOrder.setDeliveryDate(order.getDeliveryDate());
            updatedOrder.setShippingAddress(order.getShippingAddress());
            updatedOrder.setTotalPrice(order.getTotalPrice());
            updatedOrder.setTotalDiscountedPrice(order.getTotalDiscountedPrice());
            updatedOrder.setDiscount(order.getDiscount());
            updatedOrder.setOrderStatus(order.getOrderStatus());
            updatedOrder.setTotalItem(order.getTotalItem());
            // Set other properties as needed
            return orderRepository.save(updatedOrder);
        }
        return null; // Order ID is missing or not found
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    // Implement methods for Order-related operations
}
