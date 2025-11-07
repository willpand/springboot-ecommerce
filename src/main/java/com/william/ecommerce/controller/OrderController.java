package com.william.ecommerce.controller;

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
    public Order placeOrder() {
        User user = userService.getCurrentUser();
        return orderService.placeOrder(user);
    }

    @GetMapping
    public List<Order> getOrders() {
        User user = userService.getCurrentUser();
        return orderService.getUserOrders(user);
    }
}
