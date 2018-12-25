package jdbc.lb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jdbc.lb.domain.Product;

public class ProductDao implements Dao<Product, Integer> {

	private final static String url = "jdbc:h2:mem:products";
	
	public ProductDao() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url);
			String sql = "create table if not exists products("
					+ "id integer primary key auto_increment,"
					+ "title varchar(300),"
					+ "price float);";
			Statement statement = conn.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<Product> getAll() {
		Connection conn = null;
		List<Product> list = null;
		
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select* from products;";
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			list = new ArrayList<Product>();
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setTitle(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				list.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Product getById(Integer id) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url);
			String sql = "select * from products where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setTitle(rs.getString(2));
				product.setPrice(rs.getFloat(3));
				return product;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public Product add(Product entity) {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url);
			String sql = "insert into products(title, price) values(?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, entity.getTitle());
			preparedStatement.setFloat(2, entity.getPrice());
			preparedStatement.executeUpdate();
			return entity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void remove(Integer id) {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url);
			String sql = "delete from products where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Product entity) {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(url);
			String sql = "update products set title = ?, price = ? where id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, entity.getTitle());
			preparedStatement.setFloat(2, entity.getPrice());
			preparedStatement.setInt(3, entity.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
