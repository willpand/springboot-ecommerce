package com.william.ecommerce.service;

import com.william.ecommerce.dto.CartItemResponse;
import com.william.ecommerce.dto.CartResponse;
import com.william.ecommerce.entity.*;
import com.william.ecommerce.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    public Cart getOrCreateCart(User user) {
        return cartRepository.findByUser(user)
                .orElseGet(() -> {
                    Cart cart = new Cart();
                    cart.setUser(user);
                    return cartRepository.save(cart);
                });
    }

    @Transactional
    public Cart addToCart(User user, Long productId, int quantity) {
        Cart cart = getOrCreateCart(user);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(i -> i.getProduct().getId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {
            CartItem item = existingItem.get();
            item.setQuantity(item.getQuantity() + quantity);
        } else {
            CartItem newItem = new CartItem();
            newItem.setProduct(product);
            newItem.setCart(cart);
            newItem.setQuantity(quantity);
            cart.getItems().add(newItem);
        }

        // Recalculate total
        double total = cart.getItems().stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();

        cart.setTotal(total);
        cart.setUpdatedAt(java.time.LocalDateTime.now());
        return cartRepository.save(cart);
    }

    public CartResponse mapToResponse(Cart cart) {
        List<CartItemResponse> items = cart.getItems().stream()
                .map(item -> new CartItemResponse(
                        item.getId(),
                        item.getProduct().getId(),
                        item.getProduct().getName(),
                        item.getProduct().getPrice(),
                        item.getQuantity()
                ))
                .toList();

        return new CartResponse(cart.getId(), cart.getTotal(), items);
    }

    @Transactional
    public void clearCart(Cart cart) {
        cart.getItems().clear();
        cart.setTotal(0.0);
        cartRepository.save(cart);
    }
}
