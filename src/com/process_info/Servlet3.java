package com.process_info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet 
{
	private static final long serialVersionUID = 3L;
	
	// personal constructor
    public Servlet3() 
    {
        super(); // recall the superclass constructor
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String Mail = request.getParameter("mail");
		
		short Token = (short)(Math.random() * 100000);
		
		System.out.println(Token);
		
		dao.updateDB_token(Mail, (int)Token);
		
		MailUtility.sendResetLink(Mail, Token);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String Retyped_mail = request.getParameter("retyped mail");
		String New_password = request.getParameter("new password");
		String Retyped_new_password = request.getParameter("retyped new password");	
		int Token = Integer.parseInt(request.getParameter("token"));
		
		String encryptedNewPassword = EncryptUtility.hash(New_password, "SHA-256"); // encrypt_hash is defined as static method
		
		if(dao.checkDB_mail(Retyped_mail, Token))
		{	
			if(New_password.equals(Retyped_new_password))
			{
				if(New_password.length() > 4)
				{			
					dao.updateDB_password("", encryptedNewPassword, Retyped_mail);		
					
					MailUtility.sendConfirmMessage(Retyped_mail);
					
					request.setAttribute("result", "password resetted "); // make object ready to be called in jsp
							
					getServletContext() .getRequestDispatcher("/Reset_Pass_Result.jsp") .forward(request, response); 
				}
				else
				{				
					request.setAttribute("result", "new password is too short "); 
					
					getServletContext() .getRequestDispatcher("/Reset_Pass_Result.jsp") .forward(request, response); 
				}	
			}
			else
			{			
				request.setAttribute("result", "mail or new password retyped incorrectly"); 
				
				getServletContext() .getRequestDispatcher("/Reset_Pass_Result.jsp") .forward(request, response); 
			}
		}
		else
		{
			request.setAttribute("result", "tokenerror "); 
			
			getServletContext() .getRequestDispatcher("/Reset_Pass_Result.jsp") .forward(request, response); 
		}
	}
}
