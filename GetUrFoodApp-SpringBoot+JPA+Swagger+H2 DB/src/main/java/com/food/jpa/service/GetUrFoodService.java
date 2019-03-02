package com.food.jpa.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.food.jpa.dao.FoodItemsDao;
import com.food.jpa.dao.OrderDetailsDao;
import com.food.jpa.dao.UsersDao;
import com.food.jpa.data.FoodItems;
import com.food.jpa.data.OrderDetails;
import com.food.jpa.data.Users;

import lombok.NoArgsConstructor;

/**
 * @author Suresh Sadanala
 */
@Service
@NoArgsConstructor
public class GetUrFoodService {
	final String CLAZZ_NAME = "GetUrFoodService::";
	@Autowired
	UsersDao usersDao = null;

	@Autowired
	FoodItemsDao foodItemsDao = null;

	@Autowired
	OrderDetailsDao orderDetailsDao = null;

	/**
	 * Method to do user sign on
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String userSignOn(String username, String password) {
		String signOnMsg = null;
		Users user = null;
		final String METHOD_NAME = CLAZZ_NAME + "userSignOn() ";
		try {
			user = usersDao.findUsersByLoginName(username);
			if (user != null) {
				String actaulPwd = user.getPassword();
				if (!StringUtils.isEmpty(actaulPwd) && actaulPwd.equals(password)) {
					return "Authentication successful";
				} else {
					return "Authentication is failed";
				}
			} else {
				return "Authentication is failed";
			}
		} catch (Exception exception) {
			System.err.println(METHOD_NAME + " Exception occured is " + exception.getMessage());
		}
		return signOnMsg;
	}

	/**
	 * Method to retrieve the all food items
	 */
	@SuppressWarnings("unchecked")
	public <T> T getFoodItems() {
		final String METHOD_NAME = CLAZZ_NAME + "getFoodItems() ";
		List<FoodItems> foodItemList = null;
		try {
			foodItemList = foodItemsDao.findAll();
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

	/**
	 * Method to retrieve the food items by name
	 * 
	 * @param itemsName
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T findFoodItemsByName(String itemsName) {
		final String METHOD_NAME = CLAZZ_NAME + "findFoodItemsByName() ";
		List<FoodItems> foodItemList = null;
		try {
			foodItemList = foodItemsDao.findFoodItemsByItemName(itemsName);
			if (!CollectionUtils.isEmpty(foodItemList)) {
				return (T) foodItemList;
			} else {
				return (T) " There is no match data for the item name ".concat(itemsName);
			}
		} catch (Exception exception) {
			System.err.println(METHOD_NAME + " Exception occured is " + exception.getMessage());
		}
		return null;
	}

	/**
	 * Method to get the users
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getUsers() {
		final String METHOD_NAME = CLAZZ_NAME + "getUsers() ";
		List<Users> usersList = null;
		try {
			usersList = usersDao.findAll();
			if (CollectionUtils.isEmpty(usersList)) {
				return (T) "no users found";
			} else {
				return (T) usersList;
			}
		} catch (Exception exception) {
			System.err.println(METHOD_NAME + " Exception occured is " + exception.getMessage());
		}
		return null;
	}

	/**
	 * Method to place food order
	 * @param username
	 * @param orderDetails
	 * @return
	 */
	public String placeOrder(String username, OrderDetails orderDetails) {
		final String METHOD_NAME = CLAZZ_NAME + "placeOrder() for username " + username;
		String orderStatus = null;
		try {
			if (orderDetails != null) {
				Users usersByName = findUsersByName(username);
				if (usersByName != null) {
					orderDetails.setUserId(usersByName.getUserId());
					FoodItems foodItem = findFoodItemById(orderDetails.getItemId());
					orderDetails.setCreatedOn(new Date());
					if (foodItem != null) {
						orderDetails.setDescription(foodItem.getItemName() + " is placed");
						orderDetails.setStatus("1");
					} else {
						orderDetails.setDescription(" Order creation is failed");
						orderDetails.setStatus("0");
					}
					OrderDetails order = orderDetailsDao.save(orderDetails);
					if (order != null) {
						Integer orderId = order.getOrderId();
						if (orderId > 0) {
							orderStatus = "Order has been placed and order id is " + orderId;
						} else {
							orderStatus = "Order creation is failed for user " + username;
						}
					} else {
						orderStatus = "Order creation is failed for user " + username;
					}
				} else {
					orderStatus = "user is empty for username " + username + " hence order is not placed";
				}
			} else {
				orderStatus = "request order data  is empty";
			}

		} catch (Exception exception) {
			orderStatus = "Order creation is failed for user " + username;
			System.err.println(METHOD_NAME + " Exception occured is " + exception.getMessage());
		}
		return orderStatus;

	}

	/**
	 * Method to get FoodItemd by itemID
	 * @param itemId
	 */
	private FoodItems findFoodItemById(Integer itemId) {
		final String METHOD_NAME = CLAZZ_NAME + "findFoodItemById() is called for item id " + itemId;
		try {
			Optional<FoodItems> foodItems = foodItemsDao.findById(itemId);
			if (foodItems.isPresent()) {
				return foodItems.get();
			} else {
				System.out.println("Food Item is not found for the item id " + itemId);
			}
		} catch (Exception exception) {
			System.err.println(METHOD_NAME + " Exception occured is " + exception.getMessage());
		}
		return null;
	}

	/**
	 * Method to get User details using Login name
	 * 
	 * @param userName
	 * @return
	 */
	public Users findUsersByName(String userName) {
		final String METHOD_NAME = CLAZZ_NAME + "findUsersByName()";
		Users user = null;
		try {
			user = usersDao.findUsersByLoginName(userName);
		} catch (Exception exception) {
			System.err.println(METHOD_NAME + " Exception occured is " + exception.getMessage());
		}
		return user;
	}
}
