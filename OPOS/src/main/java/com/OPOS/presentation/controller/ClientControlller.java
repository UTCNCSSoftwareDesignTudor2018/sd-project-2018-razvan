package com.OPOS.presentation.controller;

import java.util.Observable;
import java.util.Observer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OPOS.business.implementation.OrderBLL;
import com.OPOS.business.implementation.ProductBLL;
import com.OPOS.business.implementation.UserBLL;
import com.OPOS.persistence.entity.Order;
import com.OPOS.persistence.entity.OrderItem;

@Controller
@RequestMapping(value="/client")
public class ClientControlller implements Observer {
	
	
	@Autowired
	UserBLL userBLL;
	
	@Autowired
	ProductBLL productBLL;
	
	@Autowired
	OrderBLL orderBLL;
	
	private Order order; 
	
	private boolean ordersChanged=false;
	
	@RequestMapping(value="/menu",method=RequestMethod.GET)
	 public ModelAndView viewMenu() {
		this.order=userBLL.save(new Order(UserBLL.SESSION_USER));
		this.orderBLL.addObserver(this);
		 ModelAndView modelAndView= new ModelAndView("client-menu");
		 modelAndView.addObject("products", productBLL.findAll());
		 modelAndView.addObject("ordersChanged", ordersChanged);
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
		this.ordersChanged=false;
		modelAndView.addObject("orders", orderBLL.findAllClosedById(UserBLL.SESSION_USER.getId()));
		return modelAndView;
	}
	
	@RequestMapping(value="/placeOrder",method=RequestMethod.POST)
	public ModelAndView placeOrder()
	{
		userBLL.placeOrder(this.order);
		
		ModelAndView modelAndView=new ModelAndView("user");
		modelAndView.addObject("ordersChanged", ordersChanged);
		return modelAndView;
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		ordersChanged=true;
	}
	
	
	
	
	

}
