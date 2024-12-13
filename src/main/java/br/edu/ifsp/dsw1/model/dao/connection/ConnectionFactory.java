package br.edu.ifsp.dsw1.model.dao.connection;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

	private ConnectionType type;
	
	public ConnectionFactory() {
		this.type = ConnectionType.MYSQL;
	}
	
	public ConnectionFactory(ConnectionType type) {
		this.type = type;
	}
	
	public Connection factory() throws SQLException {
		switch (type) {
			case MYSQL:
				return MySQLConnection.getConnection();
			case POSTGRE:
				return PostgreSQLConnection.getConnection();
			default:
				throw new IllegalArgumentException();
		}
	}
	
	public enum ConnectionType {
		MYSQL, POSTGRE
	}
}
