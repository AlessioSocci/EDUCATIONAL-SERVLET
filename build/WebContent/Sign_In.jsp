<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Sign In</title>
	</head>
	
	<body>
		
		<br>
		
		<%! String firstMessage = new String("Enter your info !! "); %>
	
		<% out.println(firstMessage); %>	
		
		<br>
		
		<br> 
		
		<form action = "Servlet"  method = "post" >
		
			<label>name :</label>
		
			<br>
		
			<input type = "text"   name = "name" > 
		
	 		<br>
	 	
	 		<br>
		
			<label>surname :</label>
		
			<br>
		
			<input type = "text"   name = "surname" > 
		
			<br>
		
			<br>
		
			<label>user :</label>
		
			<br>
		
			<input type = "text"   name = "user" > 
		
			<br>
		
			<br>
		
			<label>password :</label>
		
			<br>
		
			<input type = "text"  name = "password" > 
		
			<br>
		
			<br>
		
			<label>mail :</label>
		
			<br>
		
			<input type = "text"   name = "mail" > 
		
			<br>
		
			<br>
			
			<input type = "submit"  value = "Send" >
		
			<br>
		
			<br>
			
		</form>

		<button type = ”submit” onclick = "location.href = ' index.jsp ' ">Return</button>

	</body>

</html>