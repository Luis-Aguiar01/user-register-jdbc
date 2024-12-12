package br.edu.ifsp.dsw1.model.dao.user;

public class UserDaoFactory {
	
	private UserDaoType userDaoType;
	
	public UserDaoFactory() {
		this.userDaoType = UserDaoType.POSTGRE;
	}
	
	public UserDaoFactory(UserDaoType userDaoType) {
		this.userDaoType = userDaoType;
	}
	
	public UserDao factory() {
		switch(userDaoType) {
			case POSTGRE:
				return new PostgreUserDao();
			default:
				throw new IllegalArgumentException("Tipo inválido.");
		}
	}
	
	public enum UserDaoType {
		POSTGRE, MYSQL
	}
}
