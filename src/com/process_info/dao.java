package com.process_info;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dao 
{
	protected static boolean insertDB(String name, String surname, String user, String password, String mail, int token)
	{	
		boolean isAlreadyPresent = true; 
		
		Connection con = null;
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
						
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdbservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "admin") ; // create connection with DB
			
			Statement state = con.createStatement(); // create statement with DB
						
			ResultSet rs = state.executeQuery("SELECT user FROM customer WHERE user = ' " + user + " '; "); // send query to DB
			
			if(! rs.next()) 
			{
				isAlreadyPresent = false;	 
			}
			
			rs = state.executeQuery("SELECT mail FROM customer WHERE mail = ' " + mail + " '; ");
			
			if(! rs.next()) 
			{
				isAlreadyPresent = false;	 
			}
			else
			{
				isAlreadyPresent = true;
			}
			
			if(!isAlreadyPresent) // query only if user is not present in DB
			{
				state.executeUpdate("INSERT INTO customer " +  "(name, surname, user, password, mail, customer_id, token) VALUES (' " + name + " ', ' " + surname + " ', ' " + user + " ', ' " + password + " ', ' " + mail + " ', ' " + token + " ',  NULL)" );
				
				System.out.println("record inserted in data base"); // print in console to check
				
				try
				{
					rs.close(); // close statement and connection to DB
					state.close();
					con.close();	
				}
				catch(Exception e)	
				{
					e.printStackTrace();
				}
			} 
			else 
			{
				System.out.println("record is already present in database"); // print in console to check
				
				try
				{
					rs.close(); // close statement and connection to DB
					state.close();
					con.close();	
				}
				catch(Exception e)	
				{
					e.printStackTrace();
				}
			}
		}
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return isAlreadyPresent;
	}

	
	protected static boolean checkDB_user(String user, String password)
	{	
		String passwordInThisRow = null;
		
		boolean user_isPresent = false; 
		boolean password_isPresent = false; 
		boolean user_and_password_OK = false; 
		
		Connection con = null;
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
						
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdbservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "admin") ; // create connection with DB
			
			Statement state = con.createStatement(); // create statement with DB
						
			ResultSet rs = state.executeQuery("SELECT user, password FROM customer WHERE user = ' " + user + " '; "); // send a query to DB
						
			if(rs.next()) 
			{
				user_isPresent = true;	 
			}
						
			if (user_isPresent)
			{								
				passwordInThisRow = rs.getString("password");	
			}	
			
			rs = state.executeQuery("SELECT password FROM customer WHERE password = ' " + password + " '; "); // send a query to DB
			
			if(rs.next())
			{
				password_isPresent = true;	 
			}
			
			if (user_isPresent && password_isPresent)
			{
				password = " " + password + " ";
				
				if(passwordInThisRow.equals(password)) 
				{
					user_and_password_OK = true;
				}
			}
			
			try
			{
				rs.close(); // close statement and connection to DB
				state.close();
				con.close();	
			}
			catch(Exception e)	
			{
				e.printStackTrace();
			}
			
		}
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		return user_and_password_OK;
	
	}
	
	protected static boolean checkDB_mail(String mail, int token)
	{	
		int tokenInThisRow = 0;
		
		boolean mail_isPresent = false; 
		boolean token_isPresent = false; 
		boolean mail_and_token_OK = false; 
		
		Connection con = null;
	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
						
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdbservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "admin") ; // create connection with DB
			
			Statement state = con.createStatement(); // create statement with DB
						
			ResultSet rs = state.executeQuery("SELECT mail, token FROM customer WHERE mail = ' " + mail + " '; "); // send a query to DB
						
			if(rs.next()) 
			{
				mail_isPresent = true;	 
			}
						
			if (mail_isPresent)
			{					
				tokenInThisRow = rs.getInt("token");
			}	
			
			rs = state.executeQuery("SELECT token FROM customer WHERE token = ' " + token + " '; "); // send a query to DB
			
			if(rs.next())
			{
				token_isPresent = true;	 
			}
			
			if (mail_isPresent && token_isPresent)
			{	
				if(tokenInThisRow == token) 
				{
					mail_and_token_OK = true;
				}
			}
			
			try
			{
				rs.close(); // close statement and connection to DB
				state.close();
				con.close();	
			}
			catch(Exception e)	
			{
				e.printStackTrace();
			}
			
		}
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	
		return mail_and_token_OK;
	
	}
	
	static void updateDB_password(String retyped_user, String new_password, String retyped_mail)
	{	
		Connection con = null;
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
						
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdbservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "admin") ; // create connection with DB
			
			Statement state = con.createStatement(); // create statement with DB
						
			state.executeUpdate("UPDATE customer SET password = ' " + new_password + " '  WHERE mail =  ' " + retyped_mail + " '  OR user =  ' " + retyped_user + " ';"); // send query to DB
				
			System.out.println("password updated in data base"); // print in console to check
				
			try
			{
				state.close(); 		 // close statement and connection to DB
				con.close();	
			}
			catch(Exception e)	
			{
				e.printStackTrace();
			}
		} 
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	static void updateDB_token(String mail, int token)
	{	
		Connection con = null;
			
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
						
			con = DriverManager.getConnection("jdbc:mysql://localhost/testdbservlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "admin") ; // create connection with DB
			
			Statement state = con.createStatement(); // create statement with DB
						
			state.executeUpdate("UPDATE customer SET token = ' " + token + " '  WHERE mail =  ' " + mail + " ';"); // send query to DB
				
			System.out.println("token updated in data base"); // print in console to check
				
			try
			{
				state.close(); // close statement and connection to DB
				con.close();	
			}
			catch(Exception e)	
			{
				e.printStackTrace();
			}
		} 
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
