package br.edu.ifsp.dsw1.model.strategy;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class EncryptSHA256 implements EncryptStategy {
	
	public String encrypt(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		var algorithm = MessageDigest.getInstance("SHA-256");
		var messageDigest = algorithm.digest(password.getBytes("UTF-8"));
		
		var hexString = new StringBuilder();
        for (byte b : messageDigest) {
        	hexString.append(String.format("%02X", 0xFF & b));
        }
    	
        var encryptedPassword = hexString.toString();
		
		return encryptedPassword;
	}
}
