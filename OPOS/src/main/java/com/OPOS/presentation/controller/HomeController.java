package com.OPOS.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.OPOS.business.implementation.UserBLL;
import com.OPOS.persistence.entity.User;
import com.OPOS.persistence.entity.UserType;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	@Autowired 
	UserBLL userBLL;
	
	
	
	 @RequestMapping(value="/",method=RequestMethod.GET)
	 public ModelAndView start() {
		 ModelAndView modelAndView= new ModelAndView("login-page");
	    return modelAndView;
	 }
	 
	 @RequestMapping(value="/login",method=RequestMethod.POST)
	 public ModelAndView login(HttpServletRequest http)
	 {
		 System.out.println("asdfasdfasd");
		 String username=http.getParameter("username");
		 String password=http.getParameter("password");
		
		 boolean canLogIn= userBLL.login(username, password);
		 if (canLogIn)
		 {
			 if (userBLL.SESSION_USER.getUserType()==UserType.ADMIN)
			 {
				 return new ModelAndView("admin");
			 }else
			 {
				 return new ModelAndView("user");
			 }
		 }
		 
		 ModelAndView m=new ModelAndView("login-page");
		 m.addObject("loginError", true);
		 return m;
	 }
	 
	 @RequestMapping(value="/signUp",method=RequestMethod.POST)
	 public ModelAndView signUp()
	 {
		 return new ModelAndView("signUp");
	 }
	 
	 
	 @RequestMapping(value="/signUp/create",method=RequestMethod.POST)
	 public ModelAndView create(HttpServletRequest http)
	 {
	
		 String username=http.getParameter("username");
		 String password=http.getParameter("password");
		 String name=http.getParameter("name");
		 
		 
		 User user=new User(UserType.CLIENT,name,username,password);
		 
		 userBLL.save(user);
		 
		 ModelAndView modelAndView= new ModelAndView("signUp");
		 modelAndView.addObject("signUpValid", true);	 
		 return modelAndView;
	 }
	 
	 
	 
	 
}
