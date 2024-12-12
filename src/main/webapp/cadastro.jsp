<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	var message = request.getParameter("sucess");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Página de Cadastro</title>
</head>
<body class="flex flex-col justify-center items-center min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800">
	
	<div class="flex flex-col p-10 w-1/2 bg-white">
		<h1 class="self-center font-bold text-3xl mb-10">Cadastro</h1>
		
		<% if (message != null && message.equals("true")) { %>
			<div class="self-center justify-self-start mb-5 text-green-600 text-xl">
				Cadastro efetuado com sucesso!
			</div>
		<% } else if (message != null && message.equals("false")) { %>
			<div class="self-center justify-self-start mb-5 text-red-700 text-xl">
				Falha no cadastro. Usuário com e-mail já cadastrado.
			</div>
		<% } %>

		<form action="application.do?action=cadastro" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">person</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="name" placeholder="Nome Completo" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">person</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="email" placeholder="E-mail" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">lock</span>
				<input class="px-3 py-4 bg-transparent outline-none text-base w-full" type="password" name="password" placeholder="Password" required/>
			</div>
			
			<p class="self-center mb-4">Don't have an account? 
				<a href="register.jsp" class="text-blue-400 font-bold cursor-pointer hover:underline">
					Click here to create account.
				</a>
			</p>
			
			<input class="text-lg mt-2 bg-black py-3 self-center w-1/3 rounded-lg text-white hover:bg-gray-900 cursor-pointer font-bold" type="submit" value="Enviar">
		</form>
	</div>
</body>
</html>