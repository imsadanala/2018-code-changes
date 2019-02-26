package com.food.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.jpa.data.FoodItems;
import com.food.jpa.service.GetUrFoodService;

/**
 * @author Suresh Sadanala
 */
@RestController
@RequestMapping("food")
public class GetUrFoodController {
	@Autowired
	GetUrFoodService getUrFoodService = null;
	@GetMapping(value = "items", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FoodItems> getFoodItems() {
		List<FoodItems> list= (List<FoodItems>) getUrFoodService.getFoodItems();
		System.out.println("List<FoodItems> "+ list.size());
		return list;
	}
}
