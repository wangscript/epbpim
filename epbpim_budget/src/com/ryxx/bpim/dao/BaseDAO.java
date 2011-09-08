package com.ryxx.bpim.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;

import com.ryxx.bpim.entity.VoBase;

public interface BaseDAO<T extends VoBase, ID extends Serializable> {
	T findById(ID id);

	T findById(ID id, boolean lock);

	T fetchById(ID id);

	T fetchById(ID id, boolean lock);

	List<T> findAll();

	List<T> findPageByPage(int firstResult, int maxResults);

	List<T> findByExample(T exampleInstance, String... excludeProperty);

	T save(T entity);

	void remove(ID id);

	void remove(T entity);

	T merge(T entity);
	
	T persist(T entity);

	void setSessionFactory(SessionFactory s);
	
	void flush();
	
	void evict(T entity);
	
	List<T> findByCriteria(Criterion... criterion);
	
	List<T> findPageByPage(int firstResult, int maxResults, Criterion... criterion);
}
