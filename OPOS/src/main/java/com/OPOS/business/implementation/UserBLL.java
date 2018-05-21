package com.OPOS.business.implementation;

import org.springframework.beans.factory.annotation.Autowired;

import com.OPOS.persistence.entity.User;
import com.OPOS.persistence.repository.UserRepository;

public class UserBLL {
	
	@Autowired
	private UserRepository userRepository;
	
	//private User user;
	
	
	
	private User findById(Integer id)
	{
		return userRepository.findById(id).get();
	}
	
	private User findByEmail(String email)
	{
		return userRepository.findByEmail(email).get();
	}
	
	
	
	
	
	
	
	

}
