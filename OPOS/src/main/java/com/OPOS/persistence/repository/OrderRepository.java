package com.OPOS.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OPOS.persistence.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
