import hibernate.repository.domain.Employee;
import hibernate.repository.repository.EmployeeRepository;
import hibernate.repository.repository.Repository;

public class Main {

	public static void main(String[] args) {
		Repository repo = new EmployeeRepository();
		
		Employee empl1 = new Employee("john");
		repo.add(empl1);
		Employee empl2 = new Employee("alex");
		repo.add(empl2);
		
		repo.getAll().stream().forEach(System.out::println);
		
		repo.remove(new Long(1));
		
		repo.getAll().stream().forEach(System.out::println);
	}

}
