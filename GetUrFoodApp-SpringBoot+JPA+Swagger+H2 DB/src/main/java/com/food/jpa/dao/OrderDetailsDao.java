package com.food.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.jpa.data.OrderDetails;

/**
 * @author Suresh Sadanala
 */
public interface OrderDetailsDao extends JpaRepository<OrderDetails, Long> {

}
