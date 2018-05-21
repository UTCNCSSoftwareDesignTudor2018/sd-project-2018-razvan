package com.OPOS;



import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.OPOS.persistence.entity.Order;
import com.OPOS.persistence.entity.OrderItem;
import com.OPOS.persistence.entity.Product;
import com.OPOS.persistence.entity.User;
import com.OPOS.persistence.entity.UserType;
import com.OPOS.persistence.repository.OrderRepository;
import com.OPOS.persistence.repository.ProductRepository;
import com.OPOS.persistence.repository.UserRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class OposApplicationTests {

	
	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProductRepository productRepo;
	
	@Test
	public void test() 
	{	
		
		User user=new User(UserType.CLIENT,"razvan","raza@yahoo","pass");
		
		userRepo.save(user);
		
		Order order= new Order(user);
		
		Product p=new Product("asdf", 10, 10);
		Product p1=new Product("asdf1", 10, 10);
		
		productRepo.save(p);
		productRepo.save(p1);
		
		List<OrderItem> orderItems=new ArrayList<OrderItem>();
		
		orderItems.add(new OrderItem(10, 20, p, order));
		orderItems.add(new OrderItem(10,20,p1,order));
		
		order.setOrderItems(orderItems);
		
		orderRepo.save(order);
	
	}
	
	
	

}
