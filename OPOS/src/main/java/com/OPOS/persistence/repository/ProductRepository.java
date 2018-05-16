package com.OPOS.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OPOS.persistence.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
