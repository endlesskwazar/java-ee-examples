package jdbc.lb.dao;

import java.util.List;

public interface Dao<T, Id> {
	List<T> getAll();
	T getById(Id id);
	T add(T entity);
	void remove(Id id);
	void update(T entity);
}
