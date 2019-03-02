package com.food.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.jpa.data.OrderDetails;
import com.food.jpa.service.GetUrFoodService;
import com.food.jpa.utils.FoodUtils;

/**
 * @author Suresh Sadanala
 */
@RestController
@RequestMapping("food")
public class GetUrFoodController {

	private static final String CLAZZ_NAME = "GetUrFoodController::";

	@Autowired
	GetUrFoodService getUrFoodService = null;

	@Autowired
	FoodUtils foodUtils = null;

	@PostMapping(value = "signon", produces = "application/json")
	public ResponseEntity<String> signOn(@RequestParam(value = "requestId", required = false) String requestId,
			@RequestHeader(value = "username") String username, @RequestHeader(value = "password") String password) {
		System.out.println(CLAZZ_NAME + "signOn() is called and requestId is " + requestId);
		return foodUtils.doSignOn(username, password);
	}

	@GetMapping(value = "items", produces = "application/json")
	public ResponseEntity<Object> getFoodItems(@RequestParam(value = "requestId", required = false) String requestId,
			@RequestHeader(value = "username") String username, @RequestHeader(value = "password") String password) {
		System.out.println(CLAZZ_NAME + "getFoodItems() is called and requestId is " + requestId);
		ResponseEntity<Object> responseEntity = null;
		ResponseEntity<String> signOnResponseEntity = foodUtils.doSignOn(username, password);
		if (signOnResponseEntity.getStatusCode() != HttpStatus.OK) {
			return new ResponseEntity<Object>("Authencation is failed", HttpStatus.BAD_REQUEST);
		}
		Object items = getUrFoodService.getFoodItems();
		if (items != null) {
			responseEntity = new ResponseEntity<Object>(items, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Object>("Request is failed ", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@GetMapping(value = "items/{itemName}")
	public ResponseEntity<Object> getFoodItemByName(
			@RequestParam(value = "requestId", required = false) String requestId,
			@PathVariable(value = "itemName") String itemName, @RequestHeader(value = "username") String username,
			@RequestHeader(value = "password") String password) {
		System.out.println(CLAZZ_NAME + "getFoodItemByName() is called and requestId is " + requestId);
		ResponseEntity<Object> responseEntity = null;
		ResponseEntity<String> signOnResponseEntity = foodUtils.doSignOn(username, password);
		if (signOnResponseEntity.getStatusCode() != HttpStatus.OK) {
			return new ResponseEntity<Object>("Authencation is failed", HttpStatus.BAD_REQUEST);
		}
		Object items = getUrFoodService.findFoodItemsByName(itemName);
		if (items != null) {
			responseEntity = new ResponseEntity<Object>(items, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Object>("Request is failed ", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@GetMapping(value = "users", produces = "application/json")
	public ResponseEntity<Object> getUsers(@RequestParam(value = "requestId", required = false) String requestId,
			@RequestHeader(value = "username") String username, @RequestHeader(value = "password") String password) {
		System.out.println(CLAZZ_NAME + "getUsers() is called and requestId is " + requestId);
		ResponseEntity<Object> responseEntity = null;
		ResponseEntity<String> signOnResponseEntity = foodUtils.doSignOn(username, password);
		if (signOnResponseEntity.getStatusCode() != HttpStatus.OK) {
			return new ResponseEntity<Object>("Authencation is failed", HttpStatus.BAD_REQUEST);
		}
		Object items = getUrFoodService.getUsers();
		if (items != null) {
			responseEntity = new ResponseEntity<Object>(items, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Object>("Request is failed ", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}

	@PostMapping(value = "order", produces = "application/json")
	public ResponseEntity<Object> placeOrder(@RequestParam(value = "requestId", required = false) String requestId,
			@RequestHeader(value = "username") String username, @RequestHeader(value = "password") String password,
			@RequestBody(required = false) OrderDetails orderDetails) {
		System.out.println(CLAZZ_NAME + "placeOrder() is called and requestId is " + requestId);
		ResponseEntity<Object> responseEntity = null;
		ResponseEntity<String> signOnResponseEntity = foodUtils.doSignOn(username, password);
		if (signOnResponseEntity.getStatusCode() != HttpStatus.OK) {
			return new ResponseEntity<Object>("Authencation is failed", HttpStatus.BAD_REQUEST);
		}
		String orderStatus = getUrFoodService.placeOrder(username, orderDetails);
		if (orderStatus != null) {
			if (orderStatus.contains("fail")) {
				responseEntity = new ResponseEntity<Object>(orderStatus, HttpStatus.BAD_REQUEST);
			} else {
				responseEntity = new ResponseEntity<Object>(orderStatus, HttpStatus.OK);
			}

		} else {
			responseEntity = new ResponseEntity<Object>("Request is failed ", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
}
