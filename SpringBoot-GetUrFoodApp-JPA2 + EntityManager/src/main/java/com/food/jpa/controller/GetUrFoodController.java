package com.food.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.jpa.service.GetUrFoodService;

/**
 * @author Suresh Sadanala
 */
@RestController
@RequestMapping("food")
public class GetUrFoodController {
	private static final String CLAZZ_NAME = "GetUrFoodController::";

	@Autowired
	GetUrFoodService getUrFoodService = null;

	@GetMapping(value = "items", produces = "application/json")
	public ResponseEntity<Object> getFoodItems(@RequestParam(value = "requestId", required = false) String requestId,
			@RequestHeader(value = "username") String username, @RequestHeader(value = "password") String password) {
		System.out.println(CLAZZ_NAME + "getFoodItems() is called and requestId is " + requestId);
		ResponseEntity<Object> responseEntity = null;
		Object items = getUrFoodService.getFoodItems();
		if (items != null) {
			responseEntity = new ResponseEntity<Object>(items, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<Object>("Request is failed ", HttpStatus.BAD_REQUEST);
		}
		return responseEntity;
	}
}
