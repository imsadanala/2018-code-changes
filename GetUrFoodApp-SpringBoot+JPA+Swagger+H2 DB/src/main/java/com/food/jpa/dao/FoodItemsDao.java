package com.food.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.jpa.data.FoodItems;

/**
 * @author Suresh Sadanala
 */
public interface FoodItemsDao extends JpaRepository<FoodItems, Integer> {
	List<FoodItems> findFoodItemsByItemName(String name);
}
