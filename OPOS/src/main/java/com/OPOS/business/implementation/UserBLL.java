package com.OPOS.business.implementation;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPOS.persistence.entity.Order;
import com.OPOS.persistence.entity.OrderItem;
import com.OPOS.persistence.entity.Product;
import com.OPOS.persistence.entity.User;
import com.OPOS.persistence.entity.UserType;
import com.OPOS.persistence.repository.UserRepository;

@Service
public class UserBLL{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderBLL orderBLL;
	
	@Autowired
	private OrderItemBLL orderItemBLL;
	
	
	@Autowired
	private ProductBLL productBLL;
	
	public static User SESSION_USER;
	
	public static User SESSION_ADMIN;
	
	public User findById(Integer id)
	{
		return userRepository.findById(id).get();
	}
	
	public User findByEmail(String email)
	{
		return userRepository.findByEmail(email).get();
	}
	
	
	public boolean login(String email,String password)
	{
		boolean ok=false;
		
		Optional<User> userOptional=userRepository.findByEmail(email);
		
		if (!userOptional.isPresent())
			return ok;
		
		User user=userOptional.get();
		
		if (user!=null)
		{
			if (user.getPassword().equals(password))
			{
				ok=true;
				if (user.getUserType().equals(UserType.CLIENT))
					SESSION_USER=user;
				if (user.getUserType().equals(UserType.ADMIN))
					SESSION_ADMIN=user;
			}
		}
		return ok;
	}
	
	public void save(User user)
	{
		userRepository.save(user);
	}
	
	public List<Order> findOrdersByUserId(Integer id)
	{
		return orderBLL.findAllClosedById(id);
	}
	
	public Order save(Order order)
	{
		return orderBLL.save(order);
	}

	public void addToOrder(Order order, Integer id, Integer quantity) {
		// TODO Auto-generated method stub
		Product product=productBLL.findById(id);
		OrderItem orderItem=new OrderItem(product.getPrice()*quantity, quantity, product, order);
		order.addOrderItem(orderItem);	
	}

	public void placeOrder(Order order) {
		int totalPrice=0;
		for (OrderItem o:order.getOrderItems())
		{
			totalPrice+=o.getPrice();
			orderItemBLL.saveOrderItem(o);
			
		}
		order.setTotalPrice(totalPrice);
		orderBLL.save(order);
	}

	
	
	
	
	
	
	
	
	
	
	

}
