package com.food.jpa.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Suresh Sadanala
 */
@Entity
@Table(name = "ORDER_DETAILS")
public class OrderDetails implements Serializable {

	private static final long serialVersionUID = 7979493508651633355L;
	@Id
	@Column(name = "ORDER_ID")
	@SequenceGenerator(name = "orderIdSeq", sequenceName = "ORDER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderIdSeq")
	private Integer orderId;
	@Column(name = "USER_ID")
	private Long userId;
	@Column(name = "ITEM_ID")
	private Integer itemId;
	@Column(name = "QUANTITY")
	private Integer quantity;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "CREATED_ON")
	private Date createdOn;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
