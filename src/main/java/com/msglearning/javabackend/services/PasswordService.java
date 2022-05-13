package com.msglearning.javabackend.services;

import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordService {

    public static byte[] hash (String passwordToHash) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(passwordToHash.getBytes(StandardCharsets.UTF_8));
            return (Base64.encodeBase64String(salt) + "$" + Base64.encodeBase64String(hashedPassword)).getBytes();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }
}
