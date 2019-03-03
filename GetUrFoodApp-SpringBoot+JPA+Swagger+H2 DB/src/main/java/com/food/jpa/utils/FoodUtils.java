/**
 * 
 */
package com.food.jpa.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.food.jpa.service.GetUrFoodService;

/**
 * @author Suresh Sadanala
 *
 */
@Component
public class FoodUtils {

	private static final String CLAZZ_NAME = "FoodUtils::";
	@Autowired
	GetUrFoodService foodService = null;

	public ResponseEntity<String> doSignOn(String username, String password) {
		ResponseEntity<String> signOnResponse = null;
		String signOn = null;
		final String METHOD_NAME = CLAZZ_NAME + "findUsersByLoginName() ";
		try {
			signOn = foodService.userSignOn(username, password);
			if (!StringUtils.isEmpty(signOn) && signOn.contains("fail")) {
				signOnResponse = new ResponseEntity<String>(signOn, HttpStatus.BAD_REQUEST);
			} else {
				signOnResponse = new ResponseEntity<String>(signOn, HttpStatus.CREATED);
			}
		} catch (Exception exception) {
			System.err.println(METHOD_NAME + " Exception occured is " + exception.getMessage());
		}
		return signOnResponse;
	}
}
