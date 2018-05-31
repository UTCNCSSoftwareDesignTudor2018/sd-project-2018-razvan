package com.OPOS.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OPOS.persistence.entity.Order;

@Service
public interface OrderBLLInt {
	
	public List<Order> findAllOpen();
	
	public Order findById(Integer id);
	
	public void updateOrderAdmin(Order order);
	
	public List<Order> findAllClosedById(Integer id);
	
	public Order save(Order order);
	

}
