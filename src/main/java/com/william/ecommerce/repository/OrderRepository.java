package com.william.ecommerce.repository;

import com.william.ecommerce.entity.Order;
import com.william.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}