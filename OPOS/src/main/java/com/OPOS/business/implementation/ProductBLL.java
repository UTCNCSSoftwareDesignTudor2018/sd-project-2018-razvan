package com.OPOS.business.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.OPOS.persistence.entity.Product;
import com.OPOS.persistence.repository.ProductRepository;

@Service
public class ProductBLL  {

	@Autowired
	private ProductRepository productRepository;
	
	

	public Product findById(Integer id) {
		
		return productRepository.findById(id).get();
	}


	public List<Product> findAll() {
		return productRepository.findAll();
	}


	public void save(Product product) {
		productRepository.save(product);
		
	}


	public void delete(Product product) {
		productRepository.delete(product);
	}

}
