package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.OrderItem;
import com.oriz.backend_system.repositories.OrderItemRepository;
import com.oriz.backend_system.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItem(Long id, OrderItem orderItem) {
        Optional<OrderItem> existingOrderItem = orderItemRepository.findById(id);
        if (existingOrderItem.isPresent()) {
            OrderItem updatedOrderItem = existingOrderItem.get();
            updatedOrderItem.setOrder(orderItem.getOrder());
            updatedOrderItem.setProduct(orderItem.getProduct());
            updatedOrderItem.setSize(orderItem.getSize());
            updatedOrderItem.setQuantity(orderItem.getQuantity());
            updatedOrderItem.setPrice(orderItem.getPrice());
            updatedOrderItem.setDiscountedPrice(orderItem.getDiscountedPrice());
            updatedOrderItem.setCustomerId(orderItem.getCustomerId());
            updatedOrderItem.setDeliveryDate(orderItem.getDeliveryDate());
            // Set other properties as needed
            return orderItemRepository.save(updatedOrderItem);
        }
        return null; // OrderItem ID is missing or not found
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }

    // Implement methods for OrderItem-related operations
}
