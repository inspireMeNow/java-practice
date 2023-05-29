package com.ray.service.impl;

import com.ray.service.passwordService;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class passwordServiceImpl implements passwordService {

    public String encryptPassword(String password) {
        String salt = generateSalt();
        String securePassword = hashPassword(password, salt);

        return securePassword + "." + salt;
    }

    private String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    private String hashPassword(String password, String salt) {
        String hashedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            hashedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hashedPassword;
    }
    public boolean validatePassword(String password, String encryptedPassword) {
        String[] parts = encryptedPassword.split("\\.");
        String salt = parts[1];
        String expectedHash = parts[0];

        String hash = hashPassword(password, salt);

        return expectedHash.equals(hash);
    }

}