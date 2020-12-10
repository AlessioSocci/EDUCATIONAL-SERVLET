package com.process_info;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtility 
{
	public static void sendResetLink(String receivingMailAccount, short token) 
	{
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String sendingMailAccount = "e mail account"; // insert a valid e mail account
		String password = "password of account"; // insert password of the email account
		
		Session session = Session.getInstance
		(
			properties, new Authenticator() 
				{
					@Override protected PasswordAuthentication getPasswordAuthentication() 
						{
							return new PasswordAuthentication(sendingMailAccount, password);
						} 
				}
		);
			
		Message message = new MimeMessage(session);
		
		try 
		{
			message.setFrom(new InternetAddress(sendingMailAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receivingMailAccount));
			message.setSubject("Servlet Reset Password");
			message.setText("token = " + token + " ...copy this token and click link to reset password: " + " http://localhost:14932/java_Servlet/Reset_Pass.jsp ");
		
		} 
		catch (AddressException e) 
		{
			e.printStackTrace();
		}
		
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			Transport.send(message);
			System.out.println("link mail sent");
		}
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void sendConfirmMessage(String receivingMailAccount) 
	{
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String sendingMailAccount = "alessios1284@gmail.com";
		String password = "ooiisssseellaa1A$";
		
		Session session = Session.getInstance
		(
			properties, new Authenticator() 
				{
					@Override protected PasswordAuthentication getPasswordAuthentication() 
						{
							return new PasswordAuthentication(sendingMailAccount, password);
						} 
				}
		);
			
		Message message = new MimeMessage(session);
		
		try 
		{
			message.setFrom(new InternetAddress(sendingMailAccount));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(receivingMailAccount));
			message.setSubject("Servlet Resetted Password");
			message.setText("Password Resetted!");
		
		} 
		catch (AddressException e) 
		{
			e.printStackTrace();
		}
		
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
		
		try 
		{
			Transport.send(message);
			System.out.println("confirm mail sent");
		}
		catch (MessagingException e) 
		{
			e.printStackTrace();
		}
	}
	
}
