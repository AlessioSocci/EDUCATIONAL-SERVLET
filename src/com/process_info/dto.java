package com.process_info;

import java.io.Serializable;

public class dto implements Serializable
{
	private String name;
	private String surname;
	private String user;
	private String password;
	private String mail;
	
	// set and get public method, good practice to access a previous private declared variable:
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public String getSurname() 
	{
		return surname;
	}
	
	public void setSurname(String surname) 
	{
		this.surname = surname;
	}
	
	public String getUser() 
	{
		return user;
	}
	
	public void setUser(String user) 
	{
		this.user = user;
	}
	
	public String getPassword() 
	{
		return password;
	}
	
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	public String getMail() 
	{
		return name;
	}
	
	public void setMail(String mail) 
	{
		this.mail = mail;
	}
	
	// personal empty constructor
	public dto() 
	{
		this.name = " ";
		this.surname = " ";
		this.user = " ";
		this.password = " ";
		this.mail = " ";
	}
	
	
	// personal constructor
	public dto(String name, String surname, String user, String password, String mail) 
	{
		this.name = name;
		this.surname = surname;
		this.user = user;
		this.password = password;
		this.mail = mail;
	}
	
}
