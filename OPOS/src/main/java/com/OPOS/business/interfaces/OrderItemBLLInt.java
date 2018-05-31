package com.OPOS.business.interfaces;

import com.OPOS.persistence.entity.OrderItem;

public interface OrderItemBLLInt {

	public void saveOrderItem(OrderItem orderItem);
	
	public void deleteOrderItem(OrderItem orderItem);
	
	public OrderItem findById(Integer id) ;
	
	
}
