package jdbc.lb;

import java.util.Arrays;

import jdbc.lb.dao.ProductDao;
import jdbc.lb.domain.Product;

public class Main {

	public static void main(String[] args) {
		
		ProductDao dao = new ProductDao();
		
		//add 3 products to database
		Arrays.asList(
				new Product("boots", (float)33.3),
				new Product("phone", (float)100.5),
				new Product("pc", 22)
				)
		.stream()
		.forEach(p -> dao.add(p));
		
		//Display all products
		dao.getAll().stream().forEach(System.out::println);
		
		//Update some product
		dao.getAll().stream().findAny().ifPresent(p -> {
			p.setTitle("updated");
			dao.update(p);
		});
		
		//Display all products after update
		dao.getAll().stream().forEach(System.out::println);
		
		//Remove some product
		dao.getAll().stream().findAny().ifPresent(p -> {
			dao.remove(p.getId());
		});
		
		//Display all products after remove
		dao.getAll().stream().forEach(System.out::println);
	}

}
