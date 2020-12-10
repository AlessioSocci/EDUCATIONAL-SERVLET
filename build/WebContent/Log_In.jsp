<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Log In</title>
	</head>
	
	<body>
		
		<% // this html tag to include "inline" script in JAVA %>
		
		<form action = "Servlet" method = "get" > 	<%// ..FIX IT... doGet is not a proper method to check password, because URL display it... %>
		
			<label>user :</label>
		
			<br>
		
			<input type = "text" name = "user" > 
		
			<br>
			
			<br>
		
			<label>password :</label>
		
			<br>
		
			<input type ="password" name = "password" > 
		
			<br>
			
			<br>
		
			<input type = "submit" value = "Send" >
		
			<br>
		
			<br>
				
		</form>

		<button type = ”submit” onclick = "location.href = ' index.jsp ' ">Return</button>

	</body>

</html>