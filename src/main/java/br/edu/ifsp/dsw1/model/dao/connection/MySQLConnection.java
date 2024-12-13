package br.edu.ifsp.dsw1.model.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class MySQLConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3307/exercicio_jdbc";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	private MySQLConnection() {}
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
