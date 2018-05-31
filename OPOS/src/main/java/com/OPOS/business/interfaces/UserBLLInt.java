package com.OPOS.business.interfaces;

import java.util.List;

import com.OPOS.persistence.entity.Order;
import com.OPOS.persistence.entity.User;

public interface UserBLLInt {
	
	public User findById(Integer id);
	
	public User findByEmail(String email);
	
	public boolean login(String email,String password);
	
	public void save(User user);
	
	public List<Order> findOrdersByUserId(Integer id);
	
	public Order save(Order order);
	
	public void addToOrder(Order order, Integer id, Integer quantity);
	
	public void placeOrder(Order order);

}
