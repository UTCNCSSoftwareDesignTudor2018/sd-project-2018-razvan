package com.OPOS.persistence.entity;

public class ProductBuilder {
	
	
	public String name;
	
	public Integer price;
	
	public Integer stock;
	
	public ProductBuilder()
	{
		
	}
	
	
	public ProductBuilder setName(String name)
	{
		this.name=name;
		return this;
	}
	
	public ProductBuilder setPrice(Integer price)
	{
		this.price=price;
		return this;
	}
	
	public ProductBuilder setStock(Integer stock)
	{
		this.stock=stock;
		return this;
	}
	
	public Product build()
	{
		return new Product(this);
	}
	
}
