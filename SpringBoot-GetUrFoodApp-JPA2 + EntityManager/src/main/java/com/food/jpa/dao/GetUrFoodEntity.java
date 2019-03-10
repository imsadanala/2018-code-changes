package com.food.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class GetUrFoodEntity<T> {

	@PersistenceContext
	EntityManager entityManager = null;

	protected Class<T> entity;

	public GetUrFoodEntity() {
		super();
	}

	/**
	 * This method to save entity to DB
	 * @param getUrFoodObj
	 */
	public void persist(Object getUrFoodObj) {
		entityManager.persist(getUrFoodObj);
	}

	/**
	 * 
	 * @param primaryKeyId
	 */
	public T find(Integer primaryKeyId) {
		return entityManager.find(entity, primaryKeyId);
	}

	/**
	 * method to return entity list
	 * @return list of entities
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery(" from " + entity.getName()).getResultList();
	}

	/**
	 * method is update entity to DB
	 * @param entity
	 */
	public T merge(T entity) {
		return entityManager.merge(entity);
	}

	/**
	 * method to delete entity from DB
	 * @param entity
	 */
	public void remove(T entity) {
		entityManager.remove(entity);
	}
	
	/**
	 * method to delete entity from DB for given Id
	 * @param primaryKeyId
	 */
	@SuppressWarnings("unchecked")
	public void removeById(Integer primaryKeyId) {
		entity= (Class<T>) find(primaryKeyId);
		remove((T) entity);
	}
}
