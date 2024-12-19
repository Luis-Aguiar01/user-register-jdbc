package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.user.UserDaoFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var name = request.getParameter("name");
		var currentEmail = request.getParameter("current-email");
		var newEmail = request.getParameter("new-email");
		var password = request.getParameter("password");
		
		var dao = new UserDaoFactory().factory();
		
		if (emailExists(newEmail)) {
			return "update-user.jsp?error=new-email-unavailable";
		} else if (!emailExists(currentEmail)) {
			return "update-user.jsp?error=not-found-email";
		}
		
		var newUserData = new User(name, newEmail, password);
		
		dao.update(newUserData, currentEmail);
		
		var session = request.getSession(false);
		
		if (session != null) {
			session.invalidate();
		}
		
		return "login.jsp";
	}
	
	private boolean emailExists(String email) {
		var dao = new UserDaoFactory().factory();
		var user = dao.getByEmail(email);
		return user != null;
	}
}
