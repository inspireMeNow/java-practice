package com.ray.service.impl;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class passwordServiceImplTest {
@Resource
passwordServiceImpl passwordService;
    @Test
    void encryptPassword() {
        for(int i=0;i<102;i++){
            System.out.println(passwordService.encryptPassword("123456"));
        }
    }

    @Test
    void validatePassword() {
    }
}