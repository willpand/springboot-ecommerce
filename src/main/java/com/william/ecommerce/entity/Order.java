package com.william.ecommerce.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime createdAt;
    private Double total;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    // Constructors
    public Order() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.createdAt = orderDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<OrderItem> getItems() {
        return orderItems;
    }

    public void setItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}