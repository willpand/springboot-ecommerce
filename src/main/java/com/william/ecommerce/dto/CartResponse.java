package com.william.ecommerce.dto;

import java.util.List;

public class CartResponse {
    private Long id;
    private Double total;
    private List<CartItemResponse> items;

    public CartResponse(Long id, Double total, List<CartItemResponse> items) {
        this.id = id;
        this.total = total;
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

    public List<CartItemResponse> getItems() {
        return items;
    }

    public void setItems(List<CartItemResponse> items) {
        this.items = items;
    }
}