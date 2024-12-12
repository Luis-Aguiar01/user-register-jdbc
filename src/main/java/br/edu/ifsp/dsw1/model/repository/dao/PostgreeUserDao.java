package br.edu.ifsp.dsw1.model.repository.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifsp.dsw1.model.entity.User;
import br.edu.ifsp.dsw1.model.repository.connection.PostgreSQLConnection;

public final class PostgreeUserDao implements UserDao {

	@Override
	public void save(User user) {
		try {
			var connection = PostgreSQLConnection.getConnection();
			
			var statament = connection.prepareStatement(
					"INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
			
			statament.setString(1, user.getName());
			statament.setString(2, user.getEmail());
			statament.setString(3, user.getPassword());
			
			statament.execute();
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
			var statament = connection.prepareStatement(
					"SELECT name, email, password FROM users WHERE email = ?");
			
			statament.setString(1, email);
			
			var result = statament.executeQuery();
			
			if (result.next()) {
				var name = result.getString("name");
				var emailUser = result.getString("email");
				var password = result.getString("password");
				user = new User(name, emailUser, password);
			}
		}
		catch (SQLException e) {
			return null;
		}
		
		return user;
	}

	@Override
	public List<User> getAll() {
		return null;
	}

	@Override
	public void update(User user) {

	}

	@Override
	public void delete(String email) {
		
	}
}
