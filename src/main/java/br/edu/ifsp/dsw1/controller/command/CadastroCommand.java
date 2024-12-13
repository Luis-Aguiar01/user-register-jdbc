package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import br.edu.ifsp.dsw1.model.dao.user.UserDaoFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import br.edu.ifsp.dsw1.model.strategy.EncryptSHA256;
import br.edu.ifsp.dsw1.model.strategy.EncryptStategy;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CadastroCommand implements Command {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var name = request.getParameter("name");
		var email = request.getParameter("email");
		var password = request.getParameter("password");
		
		var repository = new UserDaoFactory().factory();
		
		String encrypedPassword;
		
		try {
			encrypedPassword = encryptPassword(password);
		}
		catch (Exception e) {
			return "cadastro.jsp?sucess=false";
		}
		
		var findUser = repository.getByEmail(email);
		if (findUser != null) {
			return "cadastro.jsp?sucess=false";
		}
		
		var user = new User(name, email, encrypedPassword);
		repository.save(user);
		
		return "login.jsp";
	}
	
	private String encryptPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		EncryptStategy strategy = new EncryptSHA256();
		return strategy.encrypt(password);
	}
}
