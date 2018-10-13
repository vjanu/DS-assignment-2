package com.food.security;

import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;

public class AESEncryption {
    private static final String ALG = "AES";
    private static final byte[] KEY = new byte[]{'h','f',4,'R','y','z','O','J','h',5,'g','w','W','r','a','z'};
    
    //encrypts the data passed to this method into a cipher text
    public static String encrypt(String data) throws Exception{
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALG);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptValue = cipher.doFinal(data.getBytes());
        return new BASE64Encoder().encode(encryptValue);
    }
   //decrypts the data passed to this method into a plain text
    public static String decrypt(String data) throws Exception{
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALG);
        cipher.init(Cipher.DECRYPT_MODE, key);
        //base64 decorder is used for decryption
        byte[] decodedValue = new BASE64Decoder().decodeBuffer(data);
        byte[] value = cipher.doFinal(decodedValue);
        return new String(value);
    }
    
    private static Key generateKey(){
        Key key = new SecretKeySpec(KEY, ALG);
        return key;
    }
}
