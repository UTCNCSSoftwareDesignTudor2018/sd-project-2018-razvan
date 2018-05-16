package com.OPOS.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderItems")
public class OrderItem {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer price;
	
	@Column
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn
	private Product product;
	
	
	@ManyToOne
	@JoinColumn
	private Order order;
	
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public OrderItem(Integer price, Integer quantity, Product product,Order order) {
		super();
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}




	public Order getOrder() {
		return order;
	}




	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
	

}
