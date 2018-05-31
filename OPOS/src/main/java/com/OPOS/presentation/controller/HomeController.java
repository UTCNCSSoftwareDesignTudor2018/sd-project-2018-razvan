package com.OPOS.presentation.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.OPOS.business.implementation.UserBLL;
import com.OPOS.business.interfaces.UserBLLInt;
import com.OPOS.business.validator.EmailValidator;
import com.OPOS.persistence.entity.User;
import com.OPOS.persistence.entity.UserBuilder;
import com.OPOS.persistence.entity.UserType;
import com.OPOS.persistence.repository.UserRepository;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	@Autowired 
	UserBLLInt userBLL;
	
	
	
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
			 User user=userBLL.findByEmail(username);
			 if (user.getUserType().equals(UserType.ADMIN))
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
		 
		 ModelAndView modelAndView= new ModelAndView("signUp");
		 if (EmailValidator.isValidEmail(username))
		 {
			 User user=new UserBuilder().setUserType(UserType.CLIENT).setName(name).setUserName(username).setPassword(password).build();
			 
			 userBLL.save(user);
			 modelAndView.addObject("signUpValid", true);
			 modelAndView.addObject("signUpInvalid", false);
			 
		 }else
		 {
			 modelAndView.addObject("signUpInvalid", true);
			 modelAndView.addObject("signUpValid", false);
		 }
	 
		 return modelAndView;
	 }
	 
	 
	 @RequestMapping(value="/logoutClient",method=RequestMethod.POST)
	 public ModelAndView logoutClient()
	 {
		 UserBLL.SESSION_USER=null;
		 return new ModelAndView("login-page");
	 }
	 
	 @RequestMapping(value="/logoutAdmin",method=RequestMethod.POST)
	 public ModelAndView logoutAdmin()
	 {
		 UserBLL.SESSION_ADMIN=null;
		 return new ModelAndView("login-page");
	 }
	 
	 
	 
}
