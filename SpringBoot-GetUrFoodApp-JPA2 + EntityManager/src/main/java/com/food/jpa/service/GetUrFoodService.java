package com.food.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.food.jpa.dao.GetUrFoodEntity;
import com.food.jpa.data.FoodItems;

/**
 * @author Suresh Sadanala
 */
@Service
public class GetUrFoodService {
	final String CLAZZ_NAME = "GetUrFoodService::";

	@Autowired
	GetUrFoodEntity<FoodItems> getUrFoodEntity;

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getFoodItems() {
		final String METHOD_NAME = CLAZZ_NAME + "getFoodItems() ";
		List<FoodItems> foodItemList = null;
		try {
			foodItemList = getUrFoodEntity.findAll();
			if (!CollectionUtils.isEmpty(foodItemList)) {
				return (T) foodItemList;
			} else {
				return (T) "There is no data available in the DB";
			}

		} catch (Exception exception) {
			System.err.println(METHOD_NAME + " Exception occured is " + exception.getMessage());
		}
		return null;
	}

}
