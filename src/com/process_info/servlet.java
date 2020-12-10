package com.process_info;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Servlet")
public class Servlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
    public Servlet() 	// personal constructor... for demonstration purposes only... 
    {
        super(); // recall the superclass constructor
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		String User = request.getParameter("user");
		String Password = request.getParameter("password");
	
		String encryptedPassword = EncryptUtility.hash(Password, "SHA-256"); // encrypt_hash is defined as static method
		
		if(dao.checkDB_user(User, encryptedPassword)) 
		{			
			HttpSession session = request.getSession(); // create a session to save user for change pass purpose
		
			session.setAttribute("session user", User);
			
			request.setAttribute("result", "Logged In as : " + User);
			
			getServletContext().getRequestDispatcher("/Log_In_Result_OK.jsp").forward(request, response); 
		}
		else
		{
			request.setAttribute("result", "User or Password are incorrect "); // for security purpose, better don't giving detailed information about the problem
			
			getServletContext().getRequestDispatcher("/Log_In_Result_ERROR.jsp").forward(request, response); 
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// request of other parameters (but not used in this example)
		String protocol = request.getProtocol();
		
		String remoteAddress = request.getRemoteAddr();
		String remoteUser = request.getRemoteUser();

		String serverAddress = request.getServerName();
		
		// recall methods of HttpServletRequest, to get parameters from client side, inserted in a JSP Form:
		String Name = request.getParameter("name");
		String Surname = request.getParameter("surname");
		String User = request.getParameter("user");
		String Password = request.getParameter("password");
		String Mail = request.getParameter("mail");
		
		String encryptedPassword = EncryptUtility.hash(Password, "SHA-256"); // encrypt_hash is defined as static method
		
		if(Password.length() > 4)
		{
			// call a method defined after this point, in this class, (we can do this because we are at the internal of a class, not in an header or in a classic structure...!) 
			if(!(dao.insertDB(Name, Surname, User, encryptedPassword, Mail, 0))) 
			{				
				// recall personal constructor defined in RecordParameters class,  to create an object of type "RecordParameters".
				dto record = new dto(Name, Surname, User, encryptedPassword, Mail); 
			
				request.setAttribute("result",  "Signed In as : "); // make object ready to be called in jsp
				
				request.setAttribute("record", record);
	
				getServletContext().getRequestDispatcher("/Sign_In_Result.jsp").forward(request, response); 
			}
			else
			{
				dto record = new dto(Name, Surname, User, encryptedPassword, Mail); 
				
				request.setAttribute("result",  "User or mail already exists ! " ); 
				
				request.setAttribute("record", record);
				
				getServletContext().getRequestDispatcher("/Sign_In_Result.jsp").forward(request, response); 
			}
		}
		else
		{
			dto record = new dto(Name, Surname, User, encryptedPassword, Mail); 
			
			request.setAttribute("result", "Pass is too short ");
				
			request.setAttribute("record", record);
				
			getServletContext().getRequestDispatcher("/Sign_In_Result.jsp").forward(request, response); 
		}

	}

	
}
