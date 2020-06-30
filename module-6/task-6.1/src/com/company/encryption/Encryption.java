package com.company.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption {
    // зашифровать пароль в MD5
    public static String encrypt(String password) throws NoSuchAlgorithmException {
        StringBuffer code = new StringBuffer(); //the hash code
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte bytes[] = password.getBytes();
        byte digest[] = messageDigest.digest(bytes); //create code
        for (int i = 0; i < digest.length; ++i) {
            code.append(Integer.toHexString(0x0100 + (digest[i] & 0x00FF)).substring(1));
        }
        return code.toString();
    }
}
