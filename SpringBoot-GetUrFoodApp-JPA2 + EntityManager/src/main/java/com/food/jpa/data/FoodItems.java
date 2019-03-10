package com.food.jpa.data;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Suresh Sadanala
 */
@Data
@NoArgsConstructor
@Table(name = "FOOD_ITEMS")
@Entity
@EqualsAndHashCode
public class FoodItems implements Serializable {

	private static final long serialVersionUID = -2925971913375843520L;
	@Id
	@Column(name = "ITEM_ID")
	private Integer itemId;

	@Column(name = "ITEM_NAME")
	private String itemName;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "PRICE")
	private Double price;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_ON")
	private Date createdOn;

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
