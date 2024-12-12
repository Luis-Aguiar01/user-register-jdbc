package br.edu.ifsp.dsw1.model.strategy;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public interface EncryptStategy {
	
	String encrypt(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException;

}
