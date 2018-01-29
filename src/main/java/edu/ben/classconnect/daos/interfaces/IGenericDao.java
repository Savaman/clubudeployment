package edu.ben.classconnect.daos.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IGenericDao<T extends Serializable> {

	T findOne(long id);

	List<T> findAll();

	void create(T entity);

	void update(T entity);

	void delete(T entity);

	void deleteById(Long entityId);

}
