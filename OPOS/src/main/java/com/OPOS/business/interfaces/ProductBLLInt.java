package com.OPOS.business.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OPOS.persistence.entity.Product;

@Service
public interface ProductBLLInt {
	
	public Product findById(Integer id);
	
	public List<Product> findAll();
	
	public void save(Product product);
	
	public void delete(Product product);
	

}
