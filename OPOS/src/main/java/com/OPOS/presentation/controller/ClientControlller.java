package com.OPOS.presentation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OPOS.business.implementation.ProductBLL;
import com.OPOS.business.implementation.UserBLL;
import com.OPOS.persistence.entity.Order;
import com.OPOS.persistence.entity.OrderItem;

@Controller
@RequestMapping(value="/client")
public class ClientControlller {
	
	
	@Autowired
	UserBLL userBLL;
	
	@Autowired
	ProductBLL productBLL;
	
	private Order order; 
	
	@RequestMapping(value="/menu",method=RequestMethod.GET)
	 public ModelAndView viewMenu() {
		this.order=userBLL.save(new Order(UserBLL.SESSION_USER));
		 ModelAndView modelAndView= new ModelAndView("client-menu");
		 modelAndView.addObject("products", productBLL.findAll());
	    return modelAndView;
	 }
	
	
	@RequestMapping(value="/addToShoppingCart",method=RequestMethod.POST)
	public ModelAndView addToShoppingCart(HttpServletRequest http)
	{
		String id=http.getParameter("id");
		String quantity=http.getParameter("quantity");
		
		if (!id.equals("")&&!quantity.equals(""))
		{		
			userBLL.addToOrder(order,Integer.parseInt(id),Integer.parseInt(quantity));
		}
		ModelAndView modelAndView=new ModelAndView("client-menu");
		modelAndView.addObject("itemAdded", true);
		modelAndView.addObject("products", productBLL.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value="/viewShoppingCart",method=RequestMethod.GET)
	public ModelAndView viewShoppingCart()
	{
		ModelAndView modelAndView=new ModelAndView("client-shoppingCart");
		modelAndView.addObject("orderItems", this.order.getOrderItems());
		int totalPrice=0;
		for (OrderItem orderItem:order.getOrderItems())
			totalPrice+=orderItem.getPrice();
		modelAndView.addObject("value", totalPrice);
		return modelAndView;
	}
	
	@RequestMapping(value="/orderHistory",method=RequestMethod.GET)
	public ModelAndView viewOrderHistory()
	{
		ModelAndView modelAndView=new ModelAndView("client-orderHistory");
		modelAndView.addObject("orders", userBLL.findOrdersByUserId(UserBLL.SESSION_USER.getId()));
		return modelAndView;
	}
	
	@RequestMapping(value="/placeOrder",method=RequestMethod.POST)
	public ModelAndView placeOrder()
	{
		userBLL.placeOrder(this.order);
		
		ModelAndView modelAndView=new ModelAndView("user");
		return modelAndView;
	}
	
	
	
	
	

}
