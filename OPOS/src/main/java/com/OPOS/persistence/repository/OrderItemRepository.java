package com.OPOS.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OPOS.persistence.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

}
