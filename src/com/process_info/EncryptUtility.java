package com.process_info;

import java.security.MessageDigest;
import javax.xml.bind.DatatypeConverter;

public class EncryptUtility 
{
	public static String hash(String input, String hashAlgorithm) // algorithm can be: MD2, MD5, SHA-1, SHA-224, SHA-256, SHA-384. SHA-512;
	{		
		byte[] inputBytes = input.getBytes(); 
		
		String output = "";
		
		try
		{
				MessageDigest messageDigest = MessageDigest.getInstance(hashAlgorithm);
				
				messageDigest.update(inputBytes);
				
				byte[] digestedBytes = messageDigest.digest();	
				
				output = DatatypeConverter.printHexBinary(digestedBytes).toLowerCase();		
		}
		catch(Exception e)
		{
			
		}
		
		return output;
	}
	
}
