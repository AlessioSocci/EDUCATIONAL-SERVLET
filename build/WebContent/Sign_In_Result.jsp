<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>

	<head>
	
		<meta charset="ISO-8859-1">
	
		<title>Sign In Result</title>
	
	</head>

	<body>
		
		${result}
		
		<br><br>
		
		<label>name:	</label>
			
		${record.name} 
		
		<br>
	
		<label>surname: </label>
				
		${record.surname} 
		
		<br>
		
		<label>user: </label>
		
		${record.user} 
		
		<br>
			
		<br>
			
		<button type = ”submit” onclick = "location.href = ' index.jsp ' ">Return</button>
		
	</body>
	
</html>