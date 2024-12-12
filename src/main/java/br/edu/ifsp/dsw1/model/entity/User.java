package br.edu.ifsp.dsw1.model.entity;

public final class User {
	
	private final String name;
	private final String email;
	private final String password;
	
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
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

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
}
