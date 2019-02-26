package com.food.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.jpa.data.Users;

/**
 * @author Suresh Sadanala
 */
@Repository
public interface UsersDao extends CrudRepository<Users, Long> {

}
