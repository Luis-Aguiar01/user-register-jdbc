package br.edu.ifsp.dsw1.model.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQLConnection {
	
	private static final String URL = "jdbc:postgresql://localhost:5432/exercicio_jdbc";
	private static final String USER = "postgres";
	private static final String PASSWORD = "Naruto123";
	
	private PostgreSQLConnection() {}
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}
