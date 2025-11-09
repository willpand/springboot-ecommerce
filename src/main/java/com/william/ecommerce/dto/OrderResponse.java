package com.william.ecommerce.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    private Long id;
    private Double total;
    private LocalDateTime createdAt;
    private List<OrderItemResponse> items;

    public OrderResponse(Long id, Double total, LocalDateTime createdAt, List<OrderItemResponse> items) {
        this.id = id;
        this.total = total;
        this.createdAt = createdAt;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItemResponse> getItems() {
        return items;
    }

    public void setItems(List<OrderItemResponse> items) {
        this.items = items;
    }
}