package com.OPOS.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OPOS.persistence.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
	
	public List<OrderItem> findByOrderId(Integer id);

}
