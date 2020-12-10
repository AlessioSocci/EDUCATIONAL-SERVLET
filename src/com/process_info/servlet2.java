package com.process_info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet 
{
	private static final long serialVersionUID = 2L;
	
	// personal constructor
    public Servlet2() 
    {
        super(); // recall the superclass constructor
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		String Retyped_user = request.getParameter("retyped user"); // ...for demonstration purposes only..
		
		String Old_password = request.getParameter("old password");
		String New_password = request.getParameter("new password");
		String Retyped_new_password = request.getParameter("retyped new password");
		
		String encryptedOldPassword = EncryptUtility.hash(Old_password, "SHA-256"); // encrypt_hash is defined as static method
		String encryptedNewPassword = EncryptUtility.hash(New_password, "SHA-256"); // encrypt_hash is defined as static method
		
		if(New_password.equals(Retyped_new_password))
		{
			HttpSession session = request.getSession(); // create a session to save user for change pass purpose
		
			String Session_user = (String) session.getAttribute("session user");
		
			request.setAttribute("result", "Logged In as : " + Session_user);
		
			if(New_password.length() > 4)
			{
				if(dao.checkDB_user(Session_user, encryptedOldPassword)) // change password only if user and old password are correctly fitted
				{
					dao.updateDB_password(Session_user, encryptedNewPassword, "");
					
					request.setAttribute("result", "password changed "); // make object ready to be called in jsp
						
					getServletContext() .getRequestDispatcher("/Change_Pass_Result.jsp") .forward(request, response); 
				}
				else
				{
					request.setAttribute("result", "old password typed incorrectly "); 
					
					getServletContext() .getRequestDispatcher("/Change_Pass_Result.jsp") .forward(request, response); 
				}
			}
			else
			{
				request.setAttribute("result", "new password is too short "); 
				
				getServletContext() .getRequestDispatcher("/Change_Pass_Result.jsp") .forward(request, response); 
			}
		
		}
		else
		{
			request.setAttribute("result", "new password retyped incorrectly"); 
			
			getServletContext() .getRequestDispatcher("//Change_Pass_Result.jsp") .forward(request, response); 
		}
		
	}
	
}
