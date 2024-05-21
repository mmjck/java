package com.mmjck.cryptography.service.serviceImpl;

import org.jasypt.util.text.StrongTextEncryptor;

import com.mmjck.cryptography.service.CryptoService;

public class CryptoServiceImpl implements CryptoService {
    private static final StrongTextEncryptor encryptor;


    static {
        encryptor = new StrongTextEncryptor();
        encryptor.setPassword("123");
        // encryptor.setPassword(System.getenv("APP_KEY"));
    }

    public String encrypt(String txt){
        return encryptor.encrypt(txt);
    }

    public String descrypt(String txt){
        return encryptor.decrypt(txt);
    }
}
