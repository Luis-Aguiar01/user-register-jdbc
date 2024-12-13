package br.edu.ifsp.dsw1.model.dao.user;

public class UserDaoFactory {
	
	private UserDaoType userDaoType;
	
	public UserDaoFactory() {
		this.userDaoType = UserDaoType.DATABASE;
	}
	
	public UserDaoFactory(UserDaoType userDaoType) {
		this.userDaoType = userDaoType;
	}
	
	public UserDao factory() {
		switch(userDaoType) {
			case DATABASE:
				return new DatabaseUserDao();
			default:
				throw new IllegalArgumentException("Tipo inválido.");
		}
	}
	
	public enum UserDaoType {
		DATABASE
	}
}
