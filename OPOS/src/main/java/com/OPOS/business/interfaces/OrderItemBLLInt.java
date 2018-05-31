package com.OPOS.business.interfaces;

import org.springframework.stereotype.Service;

import com.OPOS.persistence.entity.OrderItem;

@Service
public interface OrderItemBLLInt {

	public void saveOrderItem(OrderItem orderItem);
	
	public void deleteOrderItem(OrderItem orderItem);
	
	public OrderItem findById(Integer id) ;
	
	
}
