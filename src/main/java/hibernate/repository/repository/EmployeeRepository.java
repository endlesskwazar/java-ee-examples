package hibernate.repository.repository;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.repository.domain.Employee;

public class EmployeeRepository implements Repository<Employee, Long> {

	public List<Employee> getAll() {
		Transaction tr = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		List<Employee> list =  HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("SELECT a FROM Employee a", Employee.class).getResultList();
		tr.commit();
		return list;
	}

	public Employee getById(Long id) {
		Employee empl = HibernateUtil.getSessionFactory().getCurrentSession()
				.get(Employee.class, id);
		return empl;
	}

	public Employee add(Employee entity) {
		Transaction tr = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		HibernateUtil.getSessionFactory().getCurrentSession().save(entity);
		tr.commit();
		return entity;
	}

	public void remove(Long id) {
		Transaction tr = HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		Query query = HibernateUtil.getSessionFactory().getCurrentSession()
				.createQuery("delete Employee where id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
		tr.commit();
	}

	public void update(Employee entity) {
		Transaction tr = HibernateUtil.getSessionFactory().getCurrentSession()
				.beginTransaction();
		HibernateUtil.getSessionFactory().getCurrentSession().update(entity);
		tr.commit();
	}

}
