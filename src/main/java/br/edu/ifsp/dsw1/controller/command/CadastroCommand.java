package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.user.UserDaoFactory;
import br.edu.ifsp.dsw1.model.entity.User;
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
		
		var findUser = repository.getByEmail(email);
		if (findUser != null) {
			return "cadastro.jsp?sucess=false";
		}
		
		var user = new User(name, email, password);
		repository.save(user);
		
		return "login.jsp";
	}

}
