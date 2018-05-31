package com.OPOS.persistence.entity;

public class UserBuilder {
	

	public UserType userType;
	public String name;
	public String username;
	public String password;
	
	
	public UserBuilder()
	{
		
	}
	
	
	public UserBuilder setUserType(UserType userType)
	{
		this.userType=userType;
		return this;
	}
	
	public UserBuilder setName(String name)
	{
		this.name=name;
		return this;
	}
	
	public UserBuilder setUserName(String name)
	{
		this.username=name;
		return this;
	}
	
	public UserBuilder setPassword(String password)
	{
		this.password=password;
		return this;
	}
	
	public User build()
	{
		return new User(this);
	}
	
	
	
	
}
