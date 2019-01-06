package com.jp.services;

import com.jp.exceptions.OnlineBankingException;

public interface IEncyrptDecryptService {
	
	public void setKey(String myKey) throws OnlineBankingException;
	
	public String encrypt(String strToEncrypt, String secret) throws OnlineBankingException;
	
	public String decrypt(String strToDecrypt, String secret) throws OnlineBankingException;

}
