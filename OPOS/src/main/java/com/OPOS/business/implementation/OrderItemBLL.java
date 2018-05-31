package com.OPOS.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPOS.business.interfaces.*;
import com.OPOS.persistence.entity.OrderItem;
import com.OPOS.persistence.entity.Product;
import com.OPOS.persistence.repository.OrderItemRepository;

@Service
public class OrderItemBLL implements OrderItemBLLInt {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	ProductBLLInt productBLL;
	
	
	public void saveOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		Product product=orderItem.getProduct();
		product.setStock(product.getStock()-orderItem.getQuantity());
		productBLL.save(product);
		orderItemRepository.save(orderItem);
	}

	public void deleteOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		orderItemRepository.delete(orderItem);
		
	}


	public OrderItem findById(Integer id) {
		// TODO Auto-generated method stub
		return orderItemRepository.findById(id).get();
		
	}

}
