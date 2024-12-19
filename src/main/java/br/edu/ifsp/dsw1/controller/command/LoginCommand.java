package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.user.UserDaoFactory;
import br.edu.ifsp.dsw1.model.strategy.FactoryEncryptStrategy;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		
		var repository = new UserDaoFactory().factory();
		var user = repository.getByEmail(email);
		
		var encrypter = new FactoryEncryptStrategy().factory();
		var encryptedPassowrd = encrypter.encrypt(password);
		
		if (user != null && user.authenticate(email, encryptedPassowrd)) {
			var session = request.getSession();
			session.setAttribute("name", user.getName());
			return "home.jsp";
		}
		
		return "login.jsp?sucess=false";
	}
}
