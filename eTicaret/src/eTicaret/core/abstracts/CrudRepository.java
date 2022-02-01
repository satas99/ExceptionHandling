package eTicaret.core.abstracts;

import java.util.ArrayList;

import eTicaret.core.concretes.BusinessException;
import eTicaret.core.concretes.Entity;
import eTicaret.entities.concretes.User;

public interface CrudRepository <T extends Entity> {
	void add(T entity);
	void update(T entity);
	void delete(T entity);
	ArrayList<T> getAll();
}
