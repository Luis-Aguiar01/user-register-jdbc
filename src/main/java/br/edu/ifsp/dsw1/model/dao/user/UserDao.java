package br.edu.ifsp.dsw1.model.dao.user;

import java.util.List;

import br.edu.ifsp.dsw1.model.entity.User;

public interface UserDao {
	
	void save(User user);
	
	User getByEmail(String email);
	
	List<User> getAll();
	
	void update(User user);
	
	void delete(String email);
}
