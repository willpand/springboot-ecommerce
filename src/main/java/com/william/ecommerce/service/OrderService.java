package com.william.ecommerce.service;

import com.william.ecommerce.dto.OrderItemResponse;
import com.william.ecommerce.dto.OrderResponse;
import com.william.ecommerce.entity.*;
import com.william.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartService cartService;
    private final CartRepository cartRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, CartService cartService, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.cartService = cartService;
        this.cartRepository = cartRepository;
    }

    @Transactional
    public Order placeOrder(User user) {
        Cart cart = cartService.getOrCreateCart(user);

        if (cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
        order.setTotal(cart.getTotal());

        Order savedOrder = orderRepository.save(order);

        for (CartItem cartItem : cart.getItems()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(savedOrder);
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItemRepository.save(orderItem);
        }

        // clear the cart
        cartService.clearCart(cart);

        return savedOrder;
    }

    public List<Order> getUserOrders(User user) {
        return orderRepository.findByUser(user);
    }

    public OrderResponse mapToResponse(Order order) {
        List<OrderItemResponse> itemResponses = order.getItems().stream()
                .map(item -> new OrderItemResponse(
                        item.getId(),
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getQuantity()
                ))
                .toList();

        return new OrderResponse(
                order.getId(),
                order.getTotal(),
                order.getCreatedAt(),
                itemResponses
        );
    }
}
