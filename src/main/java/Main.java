import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.demo.domain.Employee;
import hibernate.demo.domain.Project;
import hibernate.demo.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		String[] employeeData = { "Peter Oven", "Allan Norman" };
        String[] projectData = { "IT Project", "Networking Project" };
        Set<Project> projects = new HashSet<Project>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
 
        for (String proj : projectData) {
            projects.add(new Project(proj));
        }
 
        
        for (String emp : employeeData) {
        	Transaction tr = session.beginTransaction();
            Employee employee = new Employee(emp.split(" ")[0], 
              emp.split(" ")[1]);
 
            employee.setProjects(projects);
            session.save(employee);
            tr.commit();
        }
        
        List<Employee> employeeList = session.createQuery("FROM Employee")
                .list();
        for(Employee employee : employeeList) {
            employee.getProjects();
            
        }
	}

}
