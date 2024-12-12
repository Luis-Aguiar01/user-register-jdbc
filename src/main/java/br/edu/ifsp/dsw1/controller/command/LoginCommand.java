package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.edu.ifsp.dsw1.model.dao.user.UserDaoFactory;
import br.edu.ifsp.dsw1.model.strategy.EncryptSHA256;
import br.edu.ifsp.dsw1.model.strategy.EncryptStategy;
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
		String encryptedPassowrd;
		
		try {
			encryptedPassowrd = encryptPassword(password);
		}
		catch (Exception e) {
			return "login.jsp?sucess=false";
		}
		
		if (user != null && user.authenticate(email, encryptedPassowrd)) {
			var session = request.getSession();
			session.setAttribute("authenticate", true);
			return "home.jsp";
		}
		
		return "login.jsp?sucess=false";
	}
	
	private String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		EncryptStategy strategy = new EncryptSHA256();
		return strategy.encrypt(password);
	}
}
