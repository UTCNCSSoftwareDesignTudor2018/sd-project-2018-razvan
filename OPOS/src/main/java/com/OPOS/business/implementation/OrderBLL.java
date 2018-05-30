package com.OPOS.business.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPOS.persistence.entity.Order;
import com.OPOS.persistence.entity.OrderStatus;
import com.OPOS.persistence.repository.OrderRepository;

@Service
public class OrderBLL extends Observable {

	
	@Autowired
	private OrderRepository orderRepository;
	
	
	public List<Order> findAllOpen()
	{
		List<Order> orders=orderRepository.findAll();
		List<Order> openOrders=new ArrayList<Order>();
		
		for (Order o:orders)
		{
			if (o.getOrderStatus().equals(OrderStatus.PENDING)||o.getOrderStatus().equals(OrderStatus.CONFIRMED))
				openOrders.add(o);
		}
		
		return openOrders;
	}
	
	public Order findById(Integer id)
	{
		return orderRepository.findById(id).get();
	}
	
	public void updateOrderAdmin(Order order)
	{
		setChanged();
		orderRepository.save(order);
		notifyObservers();
		clearChanged();
	}
	
	public List<Order> findAllClosedById(Integer id)
	{
		List<Order> orders=orderRepository.findByUserId(id);
		List<Order> closedOrders=new ArrayList<Order>();
		
		for (Order o:orders)
		{
			if (o.getOrderStatus().equals(OrderStatus.DELIVERED)||o.getOrderStatus().equals(OrderStatus.CONFIRMED))
				closedOrders.add(o);
		}
		
		return closedOrders;
		
	}
	
	public Order save(Order order)
	{
		return orderRepository.save(order);
	}
}
