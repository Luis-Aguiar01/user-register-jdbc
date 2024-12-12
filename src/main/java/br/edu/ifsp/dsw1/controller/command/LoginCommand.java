package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.repository.dao.UserDaoFactory;
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
		
		if (user.authenticate(email, password)) {
			var session = request.getSession();
			session.setAttribute("isLogged", true);
			return "home.jsp";
		}
		
		return "login.jsp?sucess=false";
	}
}
