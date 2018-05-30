package com.OPOS.presentation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OPOS.business.implementation.ProductBLL;
import com.OPOS.business.implementation.UserBLL;
import com.OPOS.persistence.entity.Product;
import com.OPOS.persistence.entity.UserType;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	
	@Autowired 
	UserBLL userBLL;
	
	
	@Autowired
	ProductBLL productBLL;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	 public ModelAndView viewProducts() {
		 ModelAndView modelAndView= new ModelAndView("admin-products");
		 modelAndView.addObject("products", productBLL.findAll());
	    return modelAndView;
	 }
	
	@RequestMapping(value="/orders",method=RequestMethod.GET)
	 public ModelAndView viewOrders() {
		 ModelAndView modelAndView= new ModelAndView("admin-orders");
	    return modelAndView;
	 }
	
	 @RequestMapping(value="/updateProducts",method=RequestMethod.POST)
	 public ModelAndView updateProducts(HttpServletRequest http)
	 {
		 String id=http.getParameter("id");
		 String name=http.getParameter("name");
		 String stock=http.getParameter("stock");
		 String price=http.getParameter("price");
		 
		 
		 if (id.equals(""))
		 {
			 Product product= new Product(name, Integer.parseInt(price), Integer.parseInt(stock));
			 productBLL.save(product);
		 }else
		 {
			 Product product= productBLL.findById(Integer.parseInt(id));
			 if (!name.equals(""))
			 {
				 product.setName(name);

			 }
			 if (!stock.equals(""))
			 {
				product.setStock(Integer.parseInt(stock)); 
			 }
			 
			 if (!price.equals(""))
			 {
				 product.setPrice(Integer.parseInt(price));
			 }
			 productBLL.save(product);
		 }
		 
		 ModelAndView m=new ModelAndView("admin-products");
		 m.addObject("products", productBLL.findAll());
		 return m;
	 }
	
	
	

}
