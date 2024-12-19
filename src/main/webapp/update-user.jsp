<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
	var message = request.getParameter("error");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://cdn.tailwindcss.com"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200&icon_names=mail" />
<title>Update User</title>
</head>
<body class="flex flex-col justify-center items-center min-h-screen bg-gray-500 font-mono bg-gradient-to-r from-black to-gray-800">

	<div class="flex flex-col p-5 w-1/2 bg-white">
		<h1 class="self-center font-bold text-3xl mb-10">Update</h1>
		
		<% if (message != null && message.equals("new-email-unavailable")) { %>
			<div class="self-center justify-self-start mb-5 text-red-700 text-xl">
				Falha na atualização. Novo email não disponível.
			</div>
		<% } else if (message != null && message.equals("not-found-email")) { %>
			<div class="self-center justify-self-start mb-5 text-red-700 text-xl">
				Falha na atualização. E-mail atual não cadastrado.
			</div>
		<% } %>
			
		<form action="application.do?action=update" method="POST" class="flex flex-col">
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">person</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="text" name="name" placeholder="Nome Completo" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-symbols-outlined text-gray-500">mail</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="email" name="current-email" placeholder="E-mail atual" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-symbols-outlined text-gray-500">mail</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="email" name="new-email" placeholder="E-mail novo" required/>
			</div>
			
			<div class="flex items-center border rounded-lg mb-7 bg-gray-200 px-3">
				<span class="material-icons text-gray-500">lock</span>
				<input class="px-3 py-4 bg-transparent outline-none w-full" type="password" name="password" placeholder="Password" required/>
			</div>
			
			<input class="text-lg mt-2 bg-black py-3 self-center w-1/3 rounded-lg text-white hover:bg-gray-900 cursor-pointer font-bold" type="submit" value="Enviar">
		</form>
	</div>
</body>
</html>