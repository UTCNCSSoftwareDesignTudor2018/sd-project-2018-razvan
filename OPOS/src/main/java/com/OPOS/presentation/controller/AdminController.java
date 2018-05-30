package com.OPOS.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.OPOS.business.implementation.UserBLL;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	
	@Autowired 
	UserBLL userBLL;
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	 public ModelAndView viewProducts() {
		 ModelAndView modelAndView= new ModelAndView("admin-products");
	    return modelAndView;
	 }
	
	@RequestMapping(value="/orders",method=RequestMethod.GET)
	 public ModelAndView viewOrders() {
		 ModelAndView modelAndView= new ModelAndView("admin-orders");
	    return modelAndView;
	 }
	
	
	

}
