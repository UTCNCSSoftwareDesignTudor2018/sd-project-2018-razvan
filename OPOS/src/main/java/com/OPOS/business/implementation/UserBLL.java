package com.OPOS.business.implementation;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OPOS.persistence.entity.User;
import com.OPOS.persistence.repository.UserRepository;

@Service
public class UserBLL{
	
	@Autowired
	private UserRepository userRepository;
	
	public static User SESSION_USER;
	
	public User findById(Integer id)
	{
		return userRepository.findById(id).get();
	}
	
	
	public boolean login(String email,String password)
	{
		boolean ok=false;
		
		Optional<User> userOptional=userRepository.findByEmail(email);
		
		if (!userOptional.isPresent())
			return ok;
		
		User user=userOptional.get();
		
		if (user!=null)
		{
			if (user.getPassword().equals(password))
			{
				ok=true;
				SESSION_USER=user;
			}
		}
		return ok;
	}
	
	public void save(User user)
	{
		userRepository.save(user);
	}

	
	
	
	
	
	
	
	
	
	
	

}
