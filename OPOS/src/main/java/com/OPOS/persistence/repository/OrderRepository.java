package com.OPOS.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OPOS.persistence.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	List<Order> findByUserId(Integer id);
	
	 Order save(Order order);

}
