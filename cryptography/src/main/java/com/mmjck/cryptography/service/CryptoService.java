package com.mmjck.cryptography.service;

import org.jasypt.util.text.StrongTextEncryptor;

public class CryptoService {
    private static final StrongTextEncryptor encryptor;


    static {
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword("123");
        // encryptor.setPassword(System.getenv("APP_KEY"));
    }

    public static String encrypt(String txt){
        return encryptor.encrypt(txt);
    }

    public static String descrypt(String txt){
        return encryptor.decrypt(txt);
    }
}
