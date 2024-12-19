package br.edu.ifsp.dsw1.model.strategy;

import java.security.MessageDigest;

final class EncryptSHA256 implements EncryptStategy {
	
	public String encrypt(String password) {
		var encryptedPassword = "";
		try {
			var algorithm = MessageDigest.getInstance("SHA-256");
			var messageDigest = algorithm.digest(password.getBytes("UTF-8"));
			
			var hexString = new StringBuilder();
	        for (byte b : messageDigest) {
	        	hexString.append(String.format("%02X", 0xFF & b));
	        }
	    	
	        encryptedPassword = hexString.toString();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return encryptedPassword;
	}
}
