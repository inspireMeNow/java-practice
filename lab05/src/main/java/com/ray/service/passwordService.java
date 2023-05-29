package com.ray.service;

public interface passwordService {
    public String encryptPassword(String password);
    public boolean validatePassword(String password, String encryptedPassword);
}
