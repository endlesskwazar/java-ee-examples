package jstl.beans.repository;

import java.util.List;

public interface Repository<T, Id> {
	List<T> getAll();
	T getById(Id id);
	T add(T entity);
	void remove(Id id);
	void update(T entity);
}
