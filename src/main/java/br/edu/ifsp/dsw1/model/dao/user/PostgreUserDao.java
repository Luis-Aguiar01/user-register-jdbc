package br.edu.ifsp.dsw1.model.dao.user;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifsp.dsw1.model.dao.connection.PostgreSQLConnection;
import br.edu.ifsp.dsw1.model.entity.User;

public final class PostgreUserDao implements UserDao {
	
	private static final String INSERT_USER_SQL = 
			"INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
	
	private static final String GET_USER_BY_EMAIL_SQL = 
			"SELECT name, email, password FROM users WHERE email = ?";
	
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
		return null;
	}

	@Override
	public void update(User user) {

	}

	@Override
	public void delete(String email) {
		
	}
}
