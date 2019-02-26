package com.food.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.jpa.data.FoodItems;

/**
 * @author Suresh Sadanala
 */

@Repository
public interface FoodItemsDao extends CrudRepository<FoodItems, Integer> {

}
