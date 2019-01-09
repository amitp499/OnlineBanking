package com.jp.services;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

import com.jp.exceptions.OnlineBankingException;


@Service("service_encrypt_decrypt")
public class EncryptDecryptServiceImpl implements IEncyrptDecryptService{
	 
    private  SecretKeySpec secretKey;
    private  byte[] key;
 
    public void setKey(String myKey) throws OnlineBankingException
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");  // Encodes the string to sequence of bytes using given char-set.
            sha = MessageDigest.getInstance("SHA-1");  // The MessageDigest algorithm for SHA-1
            	// Other message digest algorithms can be SHA 256, MD5 etc.
            key = sha.digest(key); // Submit the key to the algorithm and get encrypted key.
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");  // Constructs a secret key from the encrypted key.
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public String encrypt(String strToEncrypt, String secret) throws OnlineBankingException
    {
        try
        {
            setKey(secret);
            //Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
            Cipher cipher = Cipher.getInstance("AES");
            // Other types of Cipher instances: CFB/OFB etc.
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        }
        catch (Exception e)
        {
            System.out.println("Error while encrypting: " + e.toString());
        }
        return null;
    }
 
    public String decrypt(String strToDecrypt, String secret) throws OnlineBankingException
    {
        try
        {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES"); // Specify password based encryption standard version 1.5
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }
    
   
}