<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	var name = session.getAttribute("name");

	if (name == null) {
		response.sendRedirect("application.do?action=login");
		return;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gradient-to-r from-black to-gray-800 min-h-screen flex flex-col font-mono items-center justify-center box-border">
	<div class="border-solid border-2 bg-white rounded-lg w-2/3">
		<h1 class="font-bold text-4xl text-center mt-10 leading-relaxed">Welcome, <%= name %></h1>
	
		<div class="flex flex-col items-center p-10 mt-5">
			<p class="text-xl text-center mb-10"></p>
			<p class="text-xl text-center leading-relaxed"></p>
		</div>
		
		<div class="flex font-bold text-white text-lg w-full justify-center gap-5 mb-10 mt-5">
			<a href="application.do?action=logout" class="bg-red-700  w-1/4 py-4 px-4 text-center rounded-lg hover:bg-red-500 cursor-pointer"><button>Logout</button></a>
		</div>
	</div>	
</body>
</html>