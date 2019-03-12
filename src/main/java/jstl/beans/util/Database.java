package jstl.beans.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	private final static String connectionString = "jdbc:mysql://localhost/persons";
	private final static String username = "root";
	private final static String password = "";
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection (connectionString, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void initDatabase() {
		Connection conn = getConnection();
		
		String sql = "create table person(" + 
				"   id INT NOT NULL AUTO_INCREMENT," + 
				"   name VARCHAR(300) NOT NULL," + 
				"   age int NOT NULL," + 
				"   phoneNumber varchar(12)," + 
				"   PRIMARY KEY ( id )" + 
				");";
		
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
