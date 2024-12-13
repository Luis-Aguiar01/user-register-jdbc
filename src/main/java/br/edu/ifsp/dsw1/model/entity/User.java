package br.edu.ifsp.dsw1.model.entity;

import br.edu.ifsp.dsw1.model.strategy.EncryptSHA256;
import br.edu.ifsp.dsw1.model.strategy.EncryptStategy;

public final class User {
	
	private final String name;
	private final String email;
	private final String password;
	private final EncryptStategy strategy;
	
	public User(String name, String email, String password, boolean fromBD) {
		this.name = name;
		this.email = email;
		this.strategy = new EncryptSHA256();
		
		if (fromBD) {
			this.password = password;
		} else {
			this.password = encryptPassword(password);
		}
	}
	
	public User(String name, String email, String password) {
		this(name, email, password, false);
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	public boolean authenticate(String email, String password) {
		return email.equals(this.email) && password.equals(this.password);
	}
	
	private String encryptPassword(String password) {
		return strategy.encrypt(password);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
}
