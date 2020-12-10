<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Change Pass</title>
	</head>
	
	<body>
		
		<form action = "Servlet2" method = "post" > 	
			
			<label>old password :</label>
		
			<br>
		
			<input type ="password" name = "old password" > 
		
			<br>
		
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
		
			<input type = "submit" value = "Send" >
		
			<br>
		
			<br>
		
		</form>

		<button type = ”submit” onclick = "location.href = ' index.jsp ' ">Return</button>

	</body>

</html>