package com.william.ecommerce.controller;

import com.william.ecommerce.dto.OrderResponse;
import com.william.ecommerce.entity.Order;
import com.william.ecommerce.entity.User;
import com.william.ecommerce.service.OrderService;
import com.william.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final UserService userService;

    public OrderController(OrderService orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
    }

    @PostMapping("/place")
    public OrderResponse placeOrder() {
        User user = userService.getCurrentUser();
        Order order = orderService.placeOrder(user);
        return orderService.mapToResponse(order);
    }

    @GetMapping
    public List<OrderResponse> getOrders() {
        User user = userService.getCurrentUser();
        return orderService.getUserOrders(user).stream()
                .map(orderService::mapToResponse)
                .toList();
    }
}
