package br.edu.ifsp.dsw1.model.dao.user;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.PostgreSQLConnection;
import br.edu.ifsp.dsw1.model.entity.User;

public final class PostgreUserDao implements UserDao {
	
	private static final String INSERT_USER_SQL = 
			"INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
	
	private static final String GET_USER_BY_EMAIL_SQL = 
			"SELECT name, email, password FROM users WHERE email = ?";
	
	private static final String GET_ALL_USERS_SQL =
			"SELECT name, email, password FROM users";
	
	private static final String UPDATE_USER_SQL =
			"UPDATE users SET name = ?, email = ?, password = ? WHERE email = ?";
	
	private static final String DELETE_USER_SQL = 
			"DELETE FROM users WHERE email = ?";
	
	@Override
	public void save(User user) {
		try {
			var connection = PostgreSQLConnection.getConnection();
			var statament = connection.prepareStatement(INSERT_USER_SQL);
			
			statament.setString(1, user.getName());
			statament.setString(2, user.getEmail());
			statament.setString(3, user.getPassword());
			
			statament.execute();
			
			connection.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public User getByEmail(String email) {
		User user = null;
		try {
			var connection = PostgreSQLConnection.getConnection();
			var statament = connection.prepareStatement(GET_USER_BY_EMAIL_SQL);
			
			statament.setString(1, email);
			
			var result = statament.executeQuery();
			
			if (result.next()) {
				var name = result.getString("name");
				var emailUser = result.getString("email");
				var password = result.getString("password");
				user = new User(name, emailUser, password);
			}
			
			connection.close();
		}
		catch (SQLException e) {
			return null;
		}
		
		return user;
	}

	@Override
	public List<User> getAll() {
		var usersList = new LinkedList<User>();
		try {
			var connection = PostgreSQLConnection.getConnection();
			var statament = connection.createStatement();
			var result = statament.executeQuery(GET_ALL_USERS_SQL);
			
			while (result.next()) {
				var name = result.getString("name");
				var email = result.getString("email");
				var password = result.getString("password");
				var user = new User(name, email, password);
				usersList.add(user);
			}
			
			connection.close();
		}
		catch (SQLException e) {
			return new LinkedList<User>();
		}
		
		return usersList;
	}

	@Override
	public boolean update(User user) {
		int rows = 0;
		try {
			var connection = PostgreSQLConnection.getConnection();
			var statament = connection.prepareStatement(UPDATE_USER_SQL);
			
			statament.setString(1, user.getName());
			statament.setString(2, user.getEmail());
			statament.setString(3, user.getPassword());
			statament.setString(4, user.getEmail());
			
			rows = statament.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
	}

	@Override
	public boolean delete(String email) {
		int rows = 0;
		try {
			var connection = PostgreSQLConnection.getConnection();
			var statament = connection.prepareStatement(DELETE_USER_SQL);
			
			statament.setString(1, email);
			rows = statament.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rows > 0;
	}
}
