package com.OPOS;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.OPOS.persistence.entity.Order;
import com.OPOS.persistence.entity.OrderItem;
import com.OPOS.persistence.entity.OrderStatus;
import com.OPOS.persistence.entity.Product;
import com.OPOS.persistence.entity.User;
import com.OPOS.persistence.entity.UserType;
import com.OPOS.persistence.repository.OrderItemRepository;
import com.OPOS.persistence.repository.OrderRepository;
import com.OPOS.persistence.repository.ProductRepository;
import com.OPOS.persistence.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OposApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Test
	public void insertTest() {
		
		
		User user= new User(UserType.ADMIN, "Razvan", "margin@yahoo.com", "pass");
		
		userRepository.save(user);
		
		Order order= new Order(user);
		
		orderRepository.save(order);
		
		
		Product p1= new Product("pizza1",24,20);
		
		Product p2= new Product("pizza2",23,20);
		
		Product p3= new Product("pizza3",22,20);
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		
		
		//OrderItem orderItem = new OrderItem(20, 30, productRepository.findById(1).get());
		//orderItemRepository.save(orderItem);
		
		//OrderItem orderItem2 = new OrderItem(20, 30, productRepository.findById(1).get());
		//orderItemRepository.save(orderItem2);
		
		
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.");
		
		//Order order= new Order(OrderStatus.PENDING,10,new Timestamp(System.currentTimeMillis()));
		
		//orderRepository.save(order);
		
		//order.setId(1);
		//Order test= orderRepository.findById(1).get();
		
		//order.equals(test);
	}
	

}
