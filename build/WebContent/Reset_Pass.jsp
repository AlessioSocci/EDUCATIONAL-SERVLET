<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Reset Pass</title>
	</head>
	
	<body>
		
		<form action = "Servlet3" method = "post" > 	
			
		<label>retype mail :</label>
		
		<br>
		
		<input type ="text"  name = "retyped mail" > 
		
		<br>
		
		<label>new password :</label>
		
		<br>
		
		<input type ="password" name = "new password" > 
		
		<br>
		
		<br>
		
		<label>retype new password :</label>
		
		<br>
		
		<input type ="password" name = "retyped new password" > 
		
		<br>
		
		<br>
		
		<label>token :</label>
		
		<br>
		
		<input type ="text"  name = "token" > 
		
		<br>
		
		<br>
		
		<input type = "submit" value = "Send" >
		
		<br>
		
		<br>
		
		</form>

		<button type = ”submit” onclick = "location.href = ' index.jsp ' ">Return</button>
	
	</body>

</html>