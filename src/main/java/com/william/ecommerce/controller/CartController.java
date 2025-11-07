package com.william.ecommerce.controller;

import com.william.ecommerce.entity.Cart;
import com.william.ecommerce.entity.User;
import com.william.ecommerce.service.CartService;
import com.william.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam Long productId, @RequestParam int quantity) {
        User user = userService.getCurrentUser();
        return cartService.addToCart(user, productId, quantity);
    }

    @GetMapping
    public Cart getCart() {
        User user = userService.getCurrentUser();
        return cartService.getOrCreateCart(user);
    }
}
