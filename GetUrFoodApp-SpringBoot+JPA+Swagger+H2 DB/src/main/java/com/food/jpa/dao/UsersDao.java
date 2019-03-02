package com.food.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.jpa.data.Users;

/**
 * @author Suresh Sadanala
 */
public interface UsersDao extends JpaRepository<Users, Long> {
	Users findUsersByLoginName(String loginName);
}
