package com.OPOS.persistence.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	
	@OneToMany(mappedBy="order")
	@JsonIgnore
	private List<OrderItem> orderItems;
	
	
	@Enumerated(EnumType.STRING)
	@Column
	private OrderStatus orderStatus;
	
	@Column
	private Integer totalPrice;
	
	
	@Column
	@Basic
	private Timestamp startTime;
	
	@Column
	@Basic
	private Timestamp finalTime;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	



	public Order(User user) {
		super();
		this.user = user;
		this.startTime = new Timestamp(System.currentTimeMillis());
		this.orderStatus= OrderStatus.PENDING;
		this.orderItems= new ArrayList<OrderItem>();
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(Timestamp finalTime) {
		this.finalTime = finalTime;
	}
	
	





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public List<OrderItem> getOrderItems() {
		return orderItems;
	}





	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}





	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((finalTime == null) ? 0 : finalTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderStatus == null) ? 0 : orderStatus.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}





	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (finalTime == null) {
			if (other.finalTime != null)
				return false;
		} else if (!finalTime.equals(other.finalTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	



	
	
	
	
	
	
	
	
	
	
}
