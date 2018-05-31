package com.OPOS.business.interfaces;

import java.util.List;

import com.OPOS.persistence.entity.Product;

public interface ProductBLLInt {
	
	public Product findById(Integer id);
	
	public List<Product> findAll();
	
	public void save(Product product);
	
	public void delete(Product product);
	

}
