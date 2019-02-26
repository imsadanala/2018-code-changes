package com.food.jpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.jpa.dao.FoodItemsDao;
import com.food.jpa.dao.UsersDao;
import com.food.jpa.data.FoodItems;
import com.food.jpa.data.Users;

import lombok.NoArgsConstructor;

/**
 * @author Suresh Sadanala
 */
@Service
@NoArgsConstructor
public class GetUrFoodService {
	@Autowired
	UsersDao usersDao = null;

	@Autowired
	FoodItemsDao foodItemsDao = null;

	public Iterable<Users> usersList() {
		return usersDao.findAll();
	}

	public Optional<Users> getUser(Long id) {
		return usersDao.findById(id);
	}

	public Iterable<FoodItems> getFoodItems() {
		return foodItemsDao.findAll();
	}
}
