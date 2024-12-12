package br.edu.ifsp.dsw1.controller;

import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.CadastroCommand;
import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.LoginCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/application.do")
public class ApplicationServlet extends HttpServlet {
	private final static long serialVersionUID = 1L;
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		var action = request.getParameter("action");
		Command command;
		
		if ("cadastro".equals(action)) {
			command = new CadastroCommand();
		} else if ("login".equals(action)) {
			command = new LoginCommand();
		}
		else {
			command = new ErrorCommand();
		}
		
		var page = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
}
